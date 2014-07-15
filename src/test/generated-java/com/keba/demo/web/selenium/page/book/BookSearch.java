/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/SearchPage.e.vm.java
 */
package com.keba.demo.web.selenium.page.book;

import com.keba.demo.web.selenium.support.Page;
import com.keba.demo.web.selenium.support.elements.Autocomplete;
import com.keba.demo.web.selenium.support.elements.CustomWebElement;
import com.keba.demo.web.selenium.support.elements.EntityAction;
import com.keba.demo.web.selenium.support.elements.Messages;
import com.keba.demo.web.selenium.support.elements.OrderBy;
import com.keba.demo.web.selenium.support.elements.SearchForm;
import com.keba.demo.web.selenium.support.elements.StringRange;
import com.keba.demo.web.selenium.support.elements.Table;

@Page
public class BookSearch {
    public Table table;
    public EntityAction entity;
    public Messages messages;
    public BookSearchOrders orders;
    public BookSearchForm form;

    public static class BookSearchOrders extends CustomWebElement {
        public OrderBy accountId = new OrderBy("book_accountId");
        public OrderBy bookTitle = new OrderBy("book_bookTitle");
        public OrderBy numberOfPages = new OrderBy("book_numberOfPages");
    }

    public static class BookSearchForm extends SearchForm {
        public Autocomplete bookTitle = new Autocomplete("form:bookTitle");
        public StringRange numberOfPages = new StringRange("form:numberOfPages");
        public Autocomplete owner = new Autocomplete("form:ownerSelector");
        public Autocomplete bookTitleTerm = new Autocomplete("form:bookTitleTerm");
        public Autocomplete numberOfPagesTerm = new Autocomplete("form:numberOfPagesTerm");
    }
}