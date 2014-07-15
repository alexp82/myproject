/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/repository/support/SearchUsingManyToManyIT.p.vm.java
 */
package com.keba.demo.repository.support;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keba.demo.domain.Account;
import com.keba.demo.domain.Account_;
import com.keba.demo.domain.Address_;
import com.keba.demo.repository.AccountRepository;
import com.keba.demo.repository.RoleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
public class SearchUsingManyToManyIT {
    @Inject
    private AccountRepository accountRepository;

    @Inject
    private RoleRepository roleRepository;

    @Test
    public void useAND() {
        Account account = buildAccount();
        verifySize(account, sp().useAndInXToMany(), 1);
        verifySize(account, sp().useAndInXToMany().asc(Account_.email), 1);
        verifySize(account, sp().useAndInXToMany().distinct(), 1);
        verifySize(account, sp().useAndInXToMany().distinct().asc(Account_.email), 1);
        verifySize(account, sp().useAndInXToMany().distinct().fetch(Account_.homeAddress), 1);
        verifySize(account, sp().useAndInXToMany().distinct().fetch(Account_.homeAddress).asc(Account_.homeAddress, Address_.city), 1);
    }

    @Test
    public void useOR() {
        Account account = buildAccount();
        verifySize(account, sp().useOrInXToMany(), 4);
        verifySize(account, sp().useOrInXToMany().asc(Account_.email), 4);
        verifySize(account, sp().useOrInXToMany().distinct(), 3);
        verifySize(account, sp().useOrInXToMany().distinct().asc(Account_.email), 3);
        verifySize(account, sp().useOrInXToMany().distinct().fetch(Account_.homeAddress), 3);
        verifySize(account, sp().useOrInXToMany().distinct().fetch(Account_.homeAddress).asc(Account_.homeAddress, Address_.city), 3);
    }

    private Account buildAccount() {
        Account account = new Account();
        account.setSecurityRoles(newArrayList(roleRepository.getByRoleName("ROLE_ADMIN"), roleRepository.getByRoleName("ROLE_USER")));
        return account;
    }

    private void verifySize(Account account, SearchParameters s, int expectedSize) {
        assertThat(accountRepository.find(account, s)).hasSize(expectedSize);
        assertThat(accountRepository.findCount(account, s)).isEqualTo(expectedSize);
    }

    public static SearchParameters sp() {
        return new SearchParameters();
    }
}