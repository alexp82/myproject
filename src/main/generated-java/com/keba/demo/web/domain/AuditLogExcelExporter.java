/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/ExcelExporter.e.vm.java
 */
package com.keba.demo.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import com.keba.demo.domain.AuditLog;
import com.keba.demo.web.domain.support.GenericExcelExporter;
import com.keba.demo.web.faces.ConversationContextScoped;

/**
 * Exports to excel document {@link AuditLog} search criteria and result. 
 */
@Named
@ConversationContextScoped
public class AuditLogExcelExporter extends GenericExcelExporter<AuditLog> {
    @Inject
    protected AuditLogSearchForm sf;

    public AuditLogExcelExporter() {
        super("auditLog_author", "auditLog_event", "auditLog_eventDate", "auditLog_stringAttribute1", "auditLog_stringAttribute2", "auditLog_stringAttribute3");
    }

    @Override
    protected void fillResultItem(int row, AuditLog item) {
        int col = 0;
        setValue(row, col++, item.getAuthor());
        setValue(row, col++, item.getEvent());
        setDateTime(row, col++, item.getEventDate());
        setValue(row, col++, item.getStringAttribute1());
        setValue(row, col++, item.getStringAttribute2());
        setValue(row, col++, item.getStringAttribute3());
    }

    @Override
    public void fillSearchCriteria(int row) {
        useCriteriaSheet();

        setSelector(row++, 0, "auditLog_author", sf.getAuthorSelector());
        setSelector(row++, 0, "auditLog_event", sf.getEventSelector());
        setRangeDateTime(row++, 0, "auditLog_eventDate", sf.getEventDateRange());
        setSelector(row++, 0, "auditLog_stringAttribute1", sf.getStringAttribute1Selector());
        setSelector(row++, 0, "auditLog_stringAttribute2", sf.getStringAttribute2Selector());
        setSelector(row++, 0, "auditLog_stringAttribute3", sf.getStringAttribute3Selector());
    }
}