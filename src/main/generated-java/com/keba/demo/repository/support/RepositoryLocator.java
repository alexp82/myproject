/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/repository/support/RepositoryLocator.p.vm.java
 */
package com.keba.demo.repository.support;

import static com.google.common.collect.Maps.newHashMap;
import static org.hibernate.proxy.HibernateProxyHelper.getClassWithoutInitializingProxy;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.keba.demo.domain.Identifiable;

@Named
@Singleton
public class RepositoryLocator {
    private Map<Class<?>, GenericRepository<?, ?>> repositories = newHashMap();

    @Inject
    void buildCache(List<GenericRepository<?, ?>> registredRepositories) {
        for (GenericRepository<?, ?> repository : registredRepositories) {
            repositories.put(repository.getType(), repository);
        }
    }

    @SuppressWarnings("unchecked")
    public <PK extends Serializable, E extends Identifiable<PK>> GenericRepository<E, PK> getRepository(Class<? extends E> clazz) {
        return (GenericRepository<E, PK>) repositories.get(clazz);
    }

    @SuppressWarnings("unchecked")
    public <PK extends Serializable, E extends Identifiable<PK>> GenericRepository<E, PK> getRepository(E entity) {
        return (GenericRepository<E, PK>) repositories.get(getClassWithoutInitializingProxy(entity));
    }
}