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

import com.keba.demo.domain.Address;
import com.keba.demo.domain.Address_;
import com.keba.demo.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Address} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class AddressPrinter extends GenericPrinter<Address> {
    public AddressPrinter() {
        super(Address.class, Address_.city);
    }

    @Override
    public String print(Address address, Locale locale) {
        if (address == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, address.getCity());
        return ret.toString();
    }
}