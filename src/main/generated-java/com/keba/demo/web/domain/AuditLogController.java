/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/Controller.e.vm.java
 */
package com.keba.demo.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.keba.demo.domain.AuditLog;
import com.keba.demo.printer.AuditLogPrinter;
import com.keba.demo.repository.AuditLogRepository;
import com.keba.demo.web.domain.support.GenericController;
import com.keba.demo.web.permission.AuditLogPermission;

/**
 * Stateless controller for {@link AuditLog} conversation start.
 */
@Named
@Singleton
public class AuditLogController extends GenericController<AuditLog, Integer> {
    public static final String AUDITLOG_EDIT_URI = "/domain/auditLogEdit.faces";
    public static final String AUDITLOG_SELECT_URI = "/domain/auditLogSelect.faces";

    @Inject
    public AuditLogController(AuditLogRepository auditLogRepository, AuditLogPermission auditLogPermission, AuditLogPrinter auditLogPrinter) {
        super(auditLogRepository, auditLogPermission, auditLogPrinter, AUDITLOG_SELECT_URI, AUDITLOG_EDIT_URI);
    }
}