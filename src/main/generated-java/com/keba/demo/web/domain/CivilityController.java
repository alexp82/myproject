/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EnumController.enum.vm.java
 */
package com.keba.demo.web.domain;

import javax.inject.Named;
import javax.inject.Singleton;

import com.keba.demo.domain.Civility;
import com.keba.demo.web.domain.support.GenericEnumController;

@Named
@Singleton
public class CivilityController extends GenericEnumController<Civility> {
    public CivilityController() {
        super(Civility.values());
    }
}