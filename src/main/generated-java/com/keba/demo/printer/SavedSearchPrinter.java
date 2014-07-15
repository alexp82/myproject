/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/printer/Printer.e.vm.java
 */
package com.keba.demo.printer;

import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import com.keba.demo.domain.SavedSearch;
import com.keba.demo.domain.SavedSearch_;
import com.keba.demo.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link SavedSearch} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class SavedSearchPrinter extends GenericPrinter<SavedSearch> {
    public SavedSearchPrinter() {
        super(SavedSearch.class, SavedSearch_.name);
    }

    @Override
    public String print(SavedSearch savedSearch, Locale locale) {
        if (savedSearch == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, savedSearch.getName());
        return ret.toString();
    }
}