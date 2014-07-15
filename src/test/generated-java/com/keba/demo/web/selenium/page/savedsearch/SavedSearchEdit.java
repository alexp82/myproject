/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/EditPage.e.vm.java
 */
package com.keba.demo.web.selenium.page.savedsearch;

import com.keba.demo.web.selenium.support.Page;
import com.keba.demo.web.selenium.support.elements.CustomWebElement;
import com.keba.demo.web.selenium.support.elements.EditAction;
import com.keba.demo.web.selenium.support.elements.EntityAction;
import com.keba.demo.web.selenium.support.elements.Messages;
import com.keba.demo.web.selenium.support.elements.NoInverseManyToOne;
import com.keba.demo.web.selenium.support.elements.StringInput;
import com.keba.demo.web.selenium.support.elements.Upload;

@Page
public class SavedSearchEdit {
    public EditAction action;
    public Messages messages;
    public EntityAction entity;
    public SavedSearchEditForm form;
    public SavedSearchEditTabs tabs;

    public static class SavedSearchEditForm extends CustomWebElement {
        public StringInput name = new StringInput("form:name");
        public StringInput formClassname = new StringInput("form:formClassname");
        public Upload formContent = new Upload("form:formContent");

        public NoInverseManyToOne account = new NoInverseManyToOne("form:account");
    };

    public static class SavedSearchEditTabs extends CustomWebElement {
    };
}