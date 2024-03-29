/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/AnonymousHomePage.p.vm.java
 */
package com.keba.demo.web.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.keba.demo.web.selenium.support.Page;

@Page
public class AnonymousHomePage extends HomePage {
    @FindBy(partialLinkText = "Login")
    public WebElement connexionLink;

    public void connexion() {
        webClient.click(connexionLink);
    }
}