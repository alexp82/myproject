/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/EditPage.e.vm.java
 */
package com.keba.demo.web.selenium.page.address;

import com.keba.demo.web.selenium.support.Page;
import com.keba.demo.web.selenium.support.elements.CustomWebElement;
import com.keba.demo.web.selenium.support.elements.EditAction;
import com.keba.demo.web.selenium.support.elements.EntityAction;
import com.keba.demo.web.selenium.support.elements.Messages;
import com.keba.demo.web.selenium.support.elements.StringInput;

@Page
public class AddressEdit {
    public EditAction action;
    public Messages messages;
    public EntityAction entity;
    public AddressEditForm form;
    public AddressEditTabs tabs;

    public static class AddressEditForm extends CustomWebElement {
        public StringInput streetName = new StringInput("form:streetName");
        public StringInput city = new StringInput("form:city");
    };

    public static class AddressEditTabs extends CustomWebElement {
    };
}