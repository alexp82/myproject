/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/SearchForm.e.vm.java
 */
package com.keba.demo.web.domain;

import static com.keba.demo.repository.support.PropertySelector.newPropertySelector;

import javax.inject.Named;

import com.keba.demo.domain.Account;
import com.keba.demo.domain.SavedSearch;
import com.keba.demo.domain.SavedSearch_;
import com.keba.demo.repository.support.PropertySelector;
import com.keba.demo.repository.support.SearchParameters;
import com.keba.demo.web.domain.support.GenericSearchForm;
import com.keba.demo.web.faces.ConversationContextScoped;

/**
 * View Helper to search {@link SavedSearch}.
 * It exposes a {@link SavedSearch} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class SavedSearchSearchForm extends GenericSearchForm<SavedSearch, Integer, SavedSearchSearchForm> {
    private static final long serialVersionUID = 1L;
    protected SavedSearch savedSearch = new SavedSearch();
    protected PropertySelector<SavedSearch, String> nameSelector = newPropertySelector(SavedSearch_.name);
    protected PropertySelector<SavedSearch, String> formClassnameSelector = newPropertySelector(SavedSearch_.formClassname);
    protected PropertySelector<SavedSearch, Account> accountSelector = newPropertySelector(SavedSearch_.account);

    public SavedSearch getSavedSearch() {
        return savedSearch;
    }

    @Override
    protected SavedSearch getEntity() {
        return getSavedSearch();
    }

    @Override
    public SavedSearchSearchForm newInstance() {
        return new SavedSearchSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.property(nameSelector, formClassnameSelector);
        sp.property(accountSelector);
        return sp;
    }

    @Override
    public void resetWithOther(SavedSearchSearchForm other) {
        this.savedSearch = other.getSavedSearch();
        this.nameSelector = other.getNameSelector();
        this.formClassnameSelector = other.getFormClassnameSelector();
        this.accountSelector = other.getAccountSelector();
    }

    // Property selectors
    public PropertySelector<SavedSearch, String> getNameSelector() {
        return nameSelector;
    }

    public PropertySelector<SavedSearch, String> getFormClassnameSelector() {
        return formClassnameSelector;
    }

    // Relation selectors
    public PropertySelector<SavedSearch, Account> getAccountSelector() {
        return accountSelector;
    }
}
