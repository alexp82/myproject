/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/SearchFormsIT.p.vm.java
 */
package com.keba.demo.web.selenium;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.keba.demo.web.selenium.page.account.AccountSearch;
import com.keba.demo.web.selenium.support.SeleniumTest;

public class SearchFormsIT extends SeleniumTest {
    AccountSearch accountSearch;

    @Test
    public void ajaxNavigation() {
        englishHomePage();
        loginAsAnAdmin();
        webClient.step("Go to accounts, and verify their number");
        loggedHomePage.accounts();
        accountSearch.table.hasSize(53);
        webClient.step("Search by mail and verify ajax, next/previous navigation");
        accountSearch.form.email.type("1");
        accountSearch.form.search();
        accountSearch.table.paginator.isPage(1);
        accountSearch.table.hasSize(13);
        accountSearch.table.paginator.next();
        accountSearch.table.paginator.isPage(2);
        accountSearch.table.paginator.previous();
        accountSearch.table.paginator.isPage(1);
    }

    @Test
    public void orderBy() {
        englishHomePage();
        loginAsAnAdmin();
        webClient.step("Go to accounts, and verify their number");
        loggedHomePage.accounts();
        accountSearch.table.hasSize(53);
        webClient.step("Sort by columns");
        assertThat(accountSearch.orders.username.isUp()).isFalse();
        assertThat(accountSearch.orders.username.isDown()).isFalse();
        assertThat(accountSearch.orders.username.isUnsorted()).isTrue();
        assertThat(accountSearch.orders.email.isUp()).isFalse();
        assertThat(accountSearch.orders.email.isDown()).isFalse();
        assertThat(accountSearch.orders.email.isUnsorted()).isTrue();

        accountSearch.orders.username.down();
        assertThat(accountSearch.orders.username.isUp()).isFalse();
        assertThat(accountSearch.orders.username.isDown()).isTrue();
        assertThat(accountSearch.orders.username.isUnsorted()).isFalse();
        assertThat(accountSearch.orders.email.isUp()).isFalse();
        assertThat(accountSearch.orders.email.isDown()).isFalse();
        assertThat(accountSearch.orders.email.isUnsorted()).isTrue();

        accountSearch.orders.username.up();
        assertThat(accountSearch.orders.username.isUp()).isTrue();
        assertThat(accountSearch.orders.username.isDown()).isFalse();
        assertThat(accountSearch.orders.username.isUnsorted()).isFalse();
        assertThat(accountSearch.orders.email.isUp()).isFalse();
        assertThat(accountSearch.orders.email.isDown()).isFalse();
        assertThat(accountSearch.orders.email.isUnsorted()).isTrue();

        accountSearch.orders.email.up();
        assertThat(accountSearch.orders.username.isUp()).isFalse();
        assertThat(accountSearch.orders.username.isDown()).isFalse();
        assertThat(accountSearch.orders.username.isUnsorted()).isTrue();
        assertThat(accountSearch.orders.email.isUp()).isTrue();
        assertThat(accountSearch.orders.email.isDown()).isFalse();
        assertThat(accountSearch.orders.email.isUnsorted()).isFalse();
    }

    @Test
    public void complex() {
        englishHomePage();
        loginAsAnAdmin();
        loggedHomePage.accounts();
        webClient.step("Test complex searches");
        accountSearch.form.homeAddress.complete("pari", "Paris");
        accountSearch.form.search();
        accountSearch.table.hasSize(1);

        accountSearch.form.homeAddress.complete("tok", "Tokyo");
        accountSearch.form.search();
        accountSearch.table.hasSize(52);

        accountSearch.form.securityRoles.complete("use", "ROLE_USER");
        accountSearch.form.search();
        accountSearch.table.hasSize(2);

        accountSearch.form.securityRoles.complete("role_admin", "ROLE_ADMIN");
        accountSearch.form.search();
        accountSearch.table.hasSize(1);

        webClient.step("Reset search form");
        accountSearch.form.reset();

        accountSearch.form.username.type("homer");
        accountSearch.form.username.type("admin");
        accountSearch.form.search();
        accountSearch.table.hasSize(2);

        accountSearch.form.securityRoles.complete("mon", "ROLE_MONITORING");
        accountSearch.form.search();
        accountSearch.table.hasSize(1);
    }

    @Test
    public void fullText() {
        englishHomePage();
        loginAsAnAdmin();
        loggedHomePage.accounts();

        webClient.step("Full text search on all fields");
        accountSearch.form.fullText.complete("hoomer", "hoomer");
        accountSearch.form.search();
        accountSearch.table.hasSize(1);

        accountSearch.form.reset();
        accountSearch.table.hasSize(53);

        webClient.step("Full text search on a specific field");
        accountSearch.form.usernameTerm.complete("hoomehr", "hoomehr");
        accountSearch.form.search();
        accountSearch.table.hasSize(1);

        accountSearch.form.reset();
        accountSearch.table.hasSize(53);

        webClient.step("Full text search on a many to many field");
        accountSearch.form.securityRoles.complete("hadmihn", "ROLE_ADMIN");
        accountSearch.form.search();
        accountSearch.table.hasSize(1);

        accountSearch.form.reset();
        accountSearch.table.hasSize(53);

        webClient.step("Full text search on a many to one field");
        accountSearch.form.homeAddress.complete("frankisko", "San Francisco");
        accountSearch.form.homeAddress.complete("parhis", "Paris");
        accountSearch.form.search();
        accountSearch.table.hasSize(1);
    }
}