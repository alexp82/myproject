/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/element/ChooseEnum.p.vm.java
 */
package com.keba.demo.web.selenium.support.elements;

import static com.palominolabs.xpath.XPathUtils.getXPathString;

import org.openqa.selenium.By;

public class ChooseEnum<T extends Enum<? extends Enum<?>>> extends ByCustomWebElement {
    public ChooseEnum(String id) {
        super(id);
    }

    public void set(T value) {
        webClient.message("Choose " + value + " for " + id);
        String xpathExpression = "//label[@for=contains(@for, " + getXPathString(id + ":" + value.ordinal()) + ")]";
        webClient.click(By.xpath(xpathExpression));
    }

    public boolean isSelected(T value) {
        String xpathExpression = "//input[@type='radio' and @for=contains(@for, " + getXPathString(id + ":" + value.ordinal()) + ")]";
        return webClient.find(By.xpath(xpathExpression)).isSelected();
    }
}
