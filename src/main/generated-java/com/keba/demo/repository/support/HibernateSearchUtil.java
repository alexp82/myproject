/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/repository/support/HibernateSearchUtil.p.vm.java
 */
package com.keba.demo.repository.support;

import static com.google.common.collect.Lists.newArrayList;
import static org.hibernate.search.jpa.Search.getFullTextEntityManager;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@Singleton
public class HibernateSearchUtil {
    private static final Logger log = LoggerFactory.getLogger(HibernateSearchUtil.class);

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public <T> List<T> find(Class<T> clazz, SearchParameters sp, List<SingularAttribute<?, ?>> availableProperties) {
        log.info("Searching {} with terms : {} with available Properties: {}", new Object[] { clazz.getSimpleName(), sp.getTerms(), availableProperties });
        FullTextEntityManager fullTextEntityManager = getFullTextEntityManager(entityManager);
        Query query = sp.getLuceneQueryBuilder().build(fullTextEntityManager, sp, availableProperties);

        if (query == null) {
            return null;
        }

        FullTextQuery ftq = fullTextEntityManager.createFullTextQuery( //
                query, clazz);
        if (sp.getMaxResults() > 0) {
            ftq.setMaxResults(sp.getMaxResults());
        }
        return ftq.getResultList();
    }

    /**
     * Same as {@link #find(Class, SearchParameters, String[])} but will return only the id 
     */
    @SuppressWarnings("unchecked")
    public <T> List<Serializable> findId(Class<T> clazz, SearchParameters sp, List<SingularAttribute<?, ?>> availableProperties) {
        log.info("Searching {} with terms : {} with available Properties: {}", new Object[] { clazz.getSimpleName(), sp.getTerms(), availableProperties });
        FullTextEntityManager fullTextEntityManager = getFullTextEntityManager(entityManager);
        Query query = sp.getLuceneQueryBuilder().build(fullTextEntityManager, sp, availableProperties);

        if (query == null) {
            return null;
        }

        FullTextQuery ftq = fullTextEntityManager.createFullTextQuery( //
                query, clazz);
        ftq.setProjection("id");
        if (sp.getMaxResults() > 0) {
            ftq.setMaxResults(sp.getMaxResults());
        }
        List<Serializable> ids = newArrayList();
        List<Object[]> resultList = ftq.getResultList();
        for (Object[] result : resultList) {
            ids.add((Serializable) result[0]);
        }
        return ids;
    }

}