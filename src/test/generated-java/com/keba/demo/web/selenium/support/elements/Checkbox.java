/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/element/CheckBox.p.vm.java
 */
package com.keba.demo.web.selenium.support.elements;

public class Checkbox extends ByCustomWebElement {
    public Checkbox(String id) {
        super(id);
    }

    public void enable() {
        if (isDisabled()) {
            webClient.click(by);
        }
    }

    public void disable() {
        if (isEnabled()) {
            webClient.click(by);
        }
    }

    public boolean isDisabled() {
        return !isEnabled();
    }

    public boolean isEnabled() {
        return Boolean.valueOf(webClient.find(by).getAttribute("checked"));
    }
}
