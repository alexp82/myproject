/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/element/StringRange.p.vm.java
 */
package com.keba.demo.web.selenium.support.elements;

public class StringRange extends Range<String> {
    private final StringInput from;
    private final StringInput to;

    public StringRange(String id) {
        from = new StringInput(id + "RangeFrom_input");
        to = new StringInput(id + "RangeTo_input");
    }

    public void from(String value) {
        from.type(value);
    }

    public void to(String value) {
        to.type(value);
    }
}
