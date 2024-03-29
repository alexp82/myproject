/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/selectitem.enum.vm.java
 */
package com.keba.demo.web.domain;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.inject.Singleton;

import com.keba.demo.domain.Civility;

/**
 * Helper to support the <code>h:selectOneRadio</code> and <code>h:selectOneMenu</code> for {@link Civility}
 */
@Named
@Singleton
public class CivilityItems {

    /**
     * Returns a list of {@link SelectItem}/{@link Civility} ready to use in a <code>h:selectOneRadio</code>, <code>h:selectOneMenu</code> or <code>p:selectManyCheckbox</code> tags
     */
    public List<SelectItem> getList() {
        List<SelectItem> result = newArrayList();
        for (Civility civility : Civility.values()) {
            result.add(new SelectItem(civility, civility.getLabel()));
        }

        return result;
    }
}
