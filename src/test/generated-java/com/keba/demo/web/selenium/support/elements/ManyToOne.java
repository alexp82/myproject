/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/element/ManyToOne.p.vm.java
 */
package com.keba.demo.web.selenium.support.elements;

import org.apache.commons.lang.WordUtils;

public class ManyToOne extends Autocomplete {
    public Button view;
    public Button remove;

    public ManyToOne(String id) {
        super(id);
        String capitalized = WordUtils.capitalize(id.split(":")[1]);
        view = new Button("form:view" + capitalized);
        remove = new Button("form:remove" + capitalized);
    }
}
