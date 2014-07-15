/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 */
package com.keba.demo.repository;

import java.util.Date;

import javax.inject.Named;
import javax.inject.Singleton;

import com.keba.demo.domain.Account;
import com.keba.demo.domain.Civility;
import com.keba.demo.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class AccountGenerator {

    /**
     * Returns a new Account instance filled with random values.
     */
    public Account getAccount() {
        Account account = new Account();

        // simple attributes follows
        account.setUsername(ValueGenerator.getUniqueString(100));
        account.setPassword("a");
        account.setEmail(ValueGenerator.getUniqueEmail());
        account.setIsEnabled(true);
        account.setCivility(Civility.MR);
        account.setFirstName("a");
        account.setLastName("a");
        account.setBirthDate(new Date());
        account.setDescription("a");
        account.setCreationDate(new Date());
        account.setCreationAuthor("a");
        account.setLastModificationDate(new Date());
        account.setLastModificationAuthor("a");
        return account;
    }

}