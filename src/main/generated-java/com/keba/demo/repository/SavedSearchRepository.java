/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/repository/Repository.e.vm.java
 */
package com.keba.demo.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import org.hibernate.LazyInitializationException;
import org.springframework.transaction.annotation.Transactional;

import com.keba.demo.domain.SavedSearch;
import com.keba.demo.repository.support.GenericRepository;

/**
 * {@link GenericRepository} for {@link SavedSearch} 
 */
@Named
@Singleton
public class SavedSearchRepository extends GenericRepository<SavedSearch, Integer> {

    public SavedSearchRepository() {
        super(SavedSearch.class);
    }

    @Override
    public SavedSearch getNew() {
        return new SavedSearch();
    }

    @Override
    public SavedSearch getNewWithDefaults() {
        return getNew().withDefaults();
    }

    /**
     * Safe way to load the formContent content. 
     */
    @Transactional(readOnly = true)
    public byte[] getFormContent(SavedSearch savedSearch) {
        if (!savedSearch.isIdSet()) {
            return savedSearch.getFormContent();
        }

        try {
            return savedSearch.getFormContent();
        } catch (LazyInitializationException lie) { // _HACK_ as we still rely on hibernate here
            return get(savedSearch).getFormContent();
        }
    }
}