/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/printer/Printer.e.vm.java
 */
package com.keba.demo.printer;

import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import com.keba.demo.domain.AuditLog;
import com.keba.demo.domain.AuditLog_;
import com.keba.demo.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link AuditLog} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class AuditLogPrinter extends GenericPrinter<AuditLog> {
    public AuditLogPrinter() {
        super(AuditLog.class, AuditLog_.author, AuditLog_.event, AuditLog_.stringAttribute1);
    }

    @Override
    public String print(AuditLog auditLog, Locale locale) {
        if (auditLog == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, auditLog.getAuthor());
        appendIfNotEmpty(ret, auditLog.getEvent());
        appendIfNotEmpty(ret, auditLog.getStringAttribute1());
        return ret.toString();
    }
}