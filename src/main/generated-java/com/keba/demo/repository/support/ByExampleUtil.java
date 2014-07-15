/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/repository/support/ByExampleUtil.p.vm.java
 */
package com.keba.demo.repository.support;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;
import static javax.persistence.metamodel.Attribute.PersistentAttributeType.EMBEDDED;
import static javax.persistence.metamodel.Attribute.PersistentAttributeType.MANY_TO_ONE;
import static javax.persistence.metamodel.Attribute.PersistentAttributeType.ONE_TO_ONE;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.PluralAttribute;
import javax.persistence.metamodel.SingularAttribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.keba.demo.domain.Identifiable;

/**
 * Helper to create predicate by example. It processes associated entities (1 level deep).
 */
@Named
@Singleton
public class ByExampleUtil {
    private static final Logger log = LoggerFactory.getLogger(ByExampleUtil.class);

    @Inject
    private JpaUtil jpaUtil;
    @PersistenceContext
    private EntityManager em;

    public <T extends Identifiable<?>> Predicate byExampleOnEntity(Root<T> rootPath, T entityValue, CriteriaBuilder builder, SearchParameters sp) {
        if (entityValue == null) {
            return null;
        }

        Class<T> type = rootPath.getModel().getBindableJavaType();
        ManagedType<T> mt = em.getMetamodel().entity(type);

        List<Predicate> predicates = newArrayList();
        predicates.addAll(byExample(mt, rootPath, entityValue, sp, builder));
        predicates.addAll(byExampleOnCompositePk(rootPath, entityValue, sp, builder));
        predicates.addAll(byExampleOnXToOne(mt, rootPath, entityValue, sp, builder)); // 1 level deep only
        predicates.addAll(byExampleOnXToMany(mt, rootPath, entityValue, sp, builder));
        return jpaUtil.concatPredicate(sp, builder, predicates);
    }

    protected <T extends Identifiable<?>> List<Predicate> byExampleOnCompositePk(Root<T> root, T entity, SearchParameters sp, CriteriaBuilder builder) {
        String compositePropertyName = jpaUtil.compositePkPropertyName(entity);
        if (compositePropertyName == null) {
            return emptyList();
        } else {
            return newArrayList(byExampleOnEmbeddable(root.get(compositePropertyName), entity.getId(), sp, builder));
        }
    }

    public <E> Predicate byExampleOnEmbeddable(Path<E> embeddablePath, E embeddableValue, SearchParameters sp, CriteriaBuilder builder) {
        if (embeddableValue == null) {
            return null;
        }

        Class<E> type = embeddablePath.getModel().getBindableJavaType();
        ManagedType<E> mt = em.getMetamodel().embeddable(type); // note: calling .managedType() does not work

        return jpaUtil.andPredicate(builder, byExample(mt, embeddablePath, embeddableValue, sp, builder));
    }

    /**
     * Add a predicate for each simple property whose value is not null.
     */
    public <T> List<Predicate> byExample(ManagedType<T> mt, Path<T> mtPath, T mtValue, SearchParameters sp, CriteriaBuilder builder) {
        List<Predicate> predicates = newArrayList();
        for (SingularAttribute<? super T, ?> attr : mt.getSingularAttributes()) {
            if (attr.getPersistentAttributeType() == MANY_TO_ONE //
                    || attr.getPersistentAttributeType() == ONE_TO_ONE //
                    || attr.getPersistentAttributeType() == EMBEDDED) {
                continue;
            }

            Object attrValue = jpaUtil.getValue(mtValue, attr);
            if (attrValue != null) {
                if (attr.getJavaType() == String.class) {
                    if (isNotEmpty((String) attrValue)) {
                        predicates.add(jpaUtil.stringPredicate(mtPath.get(jpaUtil.stringAttribute(mt, attr)), attrValue, sp, builder));
                    }
                } else {
                    predicates.add(builder.equal(mtPath.get(jpaUtil.attribute(mt, attr)), attrValue));
                }
            }
        }
        return predicates;
    }

    /**
     * Invoke byExample method for each not null x-to-one association when their pk is not set. This allows you to search entities based on an associated
     * entity's properties value.
     */
    @SuppressWarnings("unchecked")
    public <T extends Identifiable<?>, M2O extends Identifiable<?>> List<Predicate> byExampleOnXToOne(ManagedType<T> mt, Root<T> mtPath, T mtValue,
            SearchParameters sp, CriteriaBuilder builder) {
        List<Predicate> predicates = newArrayList();
        for (SingularAttribute<? super T, ?> attr : mt.getSingularAttributes()) {
            if (attr.getPersistentAttributeType() == MANY_TO_ONE || attr.getPersistentAttributeType() == ONE_TO_ONE) {
                M2O m2oValue = (M2O) jpaUtil.getValue(mtValue, mt.getAttribute(attr.getName()));
                Class<M2O> m2oType = (Class<M2O>) attr.getBindableJavaType();
                Path<M2O> m2oPath = (Path<M2O>) mtPath.get(attr);
                ManagedType<M2O> m2oMt = em.getMetamodel().entity(m2oType);
                if (m2oValue != null) {
                    if (m2oValue.isIdSet()) { // we have an id, let's restrict only on this field
                        predicates.add(builder.equal(m2oPath.get("id"), m2oValue.getId()));
                    } else {
                        predicates.addAll(byExample(m2oMt, m2oPath, m2oValue, sp, builder));
                    }
                }
            }
        }
        return predicates;
    }

    /**
     * Construct a join predicate on collection (eg many to many, List)
     */
    public <T> List<Predicate> byExampleOnXToMany(ManagedType<T> mt, Root<T> mtPath, T mtValue, SearchParameters sp, CriteriaBuilder builder) {
        List<Predicate> predicates = newArrayList();
        for (PluralAttribute<? super T, ?, ?> pa : mt.getPluralAttributes()) {
            if (pa.getCollectionType() == PluralAttribute.CollectionType.LIST) {
                List<?> values = (List<?>) jpaUtil.getValue(mtValue, mt.getAttribute(pa.getName()));
                if (values != null && !values.isEmpty()) {
                    if (sp.getUseAndInXToMany()) {
                        if (values.size() > 3) {
                            log.warn("Please note that using AND restriction on an Many to Many relationship requires as many joins as values");
                        }
                        for (Object value : values) {
                            ListJoin<T, ?> join = mtPath.join(mt.getList(pa.getName()));
                            predicates.add(join.in(value));
                        }
                    } else {
                        ListJoin<T, ?> join = mtPath.join(mt.getList(pa.getName()));
                        predicates.add(join.in(values));
                    }
                }
            }
        }
        return predicates;
    }
}