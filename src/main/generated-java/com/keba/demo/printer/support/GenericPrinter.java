/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/printer/support/GenericPrinter.p.vm.java
 */
package com.keba.demo.printer.support;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.util.List;
import java.util.Locale;

import javax.persistence.metamodel.Attribute;

import com.keba.demo.context.LocaleHolder;
import com.keba.demo.repository.support.JpaUtil;

public abstract class GenericPrinter<T> {
    private final Class<T> clazz;
    private final List<String> displayedAttributes;

    public GenericPrinter(Class<T> clazz, Attribute<?, ?>... displayedAttributes) {
        this.clazz = clazz;
        this.displayedAttributes = newArrayList(JpaUtil.getInstance().toNames(displayedAttributes));
    }

    public Class<T> getTarget() {
        return clazz;
    }

    public String print(T document) {
        return print(document, LocaleHolder.getLocale());
    }

    public abstract String print(T object, Locale locale);

    public List<String> getDisplayedAttributes() {
        return displayedAttributes;
    }

    protected void appendIfNotEmpty(StringBuilder builder, String value) {
        if (isNotBlank(value)) {
            if (builder.length() != 0) {
                builder.append('/');
            }
            builder.append(value.trim());
        }
    }

    protected void appendIfNotEmpty(StringBuilder builder, Object value) {
        if (value != null) {
            if (builder.length() != 0) {
                builder.append('/');
            }
            builder.append(value);
        }
    }
}