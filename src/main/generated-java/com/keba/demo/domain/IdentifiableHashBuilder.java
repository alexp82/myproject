/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/domain/support/IdentifiableHashBuilder.p.vm.java
 */
package com.keba.demo.domain;

import java.io.Serializable;

import org.slf4j.Logger;

/**
 * The first time the {@link #hash(Logger, Identifiable)} is called, we check if the primary key is present or not.
 * <ul>
 * <li>If yes: we use it to get the hash</li>
 * <li>If no: we use a VMID during the entire life of this instance even if later on this instance is assigned a primary key.</li>
 * </ul>
 */
public class IdentifiableHashBuilder implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object technicalId;

    public int hash(Logger log, Identifiable<?> identifiable) {
        if (technicalId == null) {
            if (identifiable.isIdSet()) {
                technicalId = identifiable.getId();
            } else {
                technicalId = new java.rmi.dgc.VMID();
                log.warn("DEVELOPER: hashCode is not safe." //
                        + "If you encounter this message you should take the time to carefuly " //
                        + "review the equals/hashCode methods for: " + identifiable.getClass().getCanonicalName() //
                        + " You may consider using a business key.");
            }
        }
        return technicalId.hashCode();
    }
}
