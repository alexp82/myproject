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

import com.keba.demo.domain.Legacy;
import com.keba.demo.domain.Legacy_;
import com.keba.demo.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Legacy} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class LegacyPrinter extends GenericPrinter<Legacy> {
    public LegacyPrinter() {
        super(Legacy.class, Legacy_.extraInfo);
    }

    @Override
    public String print(Legacy legacy, Locale locale) {
        if (legacy == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, legacy.getExtraInfo());
        return ret.toString();
    }
}