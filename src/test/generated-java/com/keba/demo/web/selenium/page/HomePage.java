/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/HomePage.p.vm.java
 */
package com.keba.demo.web.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.keba.demo.web.selenium.support.Page;
import com.keba.demo.web.selenium.support.WebClient;

@Page
public class HomePage {
    @FindBy(id = "form:home_link")
    public WebElement home;
    @FindBy(id = "form:selectAccounts")
    public WebElement accountsLink;
    @FindBy(id = "form:selectAddresses")
    public WebElement addressesLink;
    @FindBy(id = "form:selectAuditLogs")
    public WebElement auditLogsLink;
    @FindBy(id = "form:selectBooks")
    public WebElement booksLink;
    @FindBy(id = "form:selectDocuments")
    public WebElement documentsLink;
    @FindBy(id = "form:selectLegacies")
    public WebElement legaciesLink;
    @FindBy(id = "form:selectMoreTypesDemos")
    public WebElement moreTypesDemosLink;
    @FindBy(id = "form:selectRoles")
    public WebElement rolesLink;
    @FindBy(id = "form:selectSavedSearchs")
    public WebElement savedSearchsLink;
    @FindBy(id = "form:switchToFrench")
    public WebElement switchToFrench;
    @FindBy(id = "form:switchToEnglish")
    public WebElement switchToEnglish;
    @FindBy(id = "form:messages")
    public WebElement messagesPanel;

    protected WebClient webClient;

    public void home() {
        webClient.click(home);
    }

    public void switchToEnglish() {
        webClient.click(switchToEnglish);
    }

    public void switchToFrench() {
        webClient.click(switchToFrench);
    }

    public void accounts() {
        webClient.click(accountsLink);
    }

    public void addresses() {
        webClient.click(addressesLink);
    }

    public void auditLogs() {
        webClient.click(auditLogsLink);
    }

    public void books() {
        webClient.click(booksLink);
    }

    public void documents() {
        webClient.click(documentsLink);
    }

    public void legacies() {
        webClient.click(legaciesLink);
    }

    public void moreTypesDemos() {
        webClient.click(moreTypesDemosLink);
    }

    public void roles() {
        webClient.click(rolesLink);
    }

    public void savedSearchs() {
        webClient.click(savedSearchsLink);
    }

    public void hasText(String... values) {
        for (String value : values) {
            webClient.waitUntilTextIsPresent(value);
        }
    }

    public void hasMessage(String... values) {
        for (String value : values) {
            webClient.waitUntilTextIsPresent(messagesPanel, value);
        }
    }

    protected void clickEdit(String value) {
        webClient.clickLinkTitle("Edit " + value);
    }

    protected void clickAdd(String value) {
        webClient.clickLinkTitle("Add " + value);
    }

    protected void clickDelete(String value) {
        webClient.clickLinkTitle("Delete " + value);
    }

    protected void clickRemove(String value) {
        webClient.clickLinkTitle("Remove " + value);
    }

    protected void clickSelect(String value) {
        webClient.clickLinkTitle("Select " + value);
    }
}