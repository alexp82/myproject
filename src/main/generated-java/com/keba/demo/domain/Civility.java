/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/enum/Enum.enum.vm.java
 */
package com.keba.demo.domain;

import com.keba.demo.util.ResourcesUtil;

public enum Civility implements LabelizedEnum {
    MR, //
    MS;

    @Override
    public String getLabel() {
        return ResourcesUtil.getInstance().getProperty("Civility_" + name());
    }

    public static Civility fromLabel(String label) {
        if (label == null) {
            return null;
        }
        for (Civility enumValue : Civility.values()) {
            if (label.equals(enumValue.getLabel())) {
                return enumValue;
            }
        }
        return null;
    }
}