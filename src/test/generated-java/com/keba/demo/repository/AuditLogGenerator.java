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

import com.keba.demo.domain.AuditLog;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class AuditLogGenerator {

    /**
     * Returns a new AuditLog instance filled with random values.
     */
    public AuditLog getAuditLog() {
        AuditLog auditLog = new AuditLog();

        // simple attributes follows
        auditLog.setAuthor("a");
        auditLog.setEvent("a");
        auditLog.setEventDate(new Date());
        auditLog.setStringAttribute1("a");
        auditLog.setStringAttribute2("a");
        auditLog.setStringAttribute3("a");
        return auditLog;
    }

}