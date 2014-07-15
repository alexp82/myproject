/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/EditPage.e.vm.java
 */
package com.keba.demo.web.selenium.page.role;

import com.keba.demo.web.selenium.support.Page;
import com.keba.demo.web.selenium.support.elements.CustomWebElement;
import com.keba.demo.web.selenium.support.elements.EditAction;
import com.keba.demo.web.selenium.support.elements.EntityAction;
import com.keba.demo.web.selenium.support.elements.Messages;
import com.keba.demo.web.selenium.support.elements.StringInput;

@Page
public class RoleEdit {
    public EditAction action;
    public Messages messages;
    public EntityAction entity;
    public RoleEditForm form;
    public RoleEditTabs tabs;

    public static class RoleEditForm extends CustomWebElement {
        public StringInput roleName = new StringInput("form:roleName");
    };

    public static class RoleEditTabs extends CustomWebElement {
    };
}