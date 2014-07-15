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

import com.keba.demo.domain.Legacy;
import com.keba.demo.web.domain.support.GenericExcelExporter;
import com.keba.demo.web.faces.ConversationContextScoped;

/**
 * Exports to excel document {@link Legacy} search criteria and result. 
 */
@Named
@ConversationContextScoped
public class LegacyExcelExporter extends GenericExcelExporter<Legacy> {
    @Inject
    protected LegacySearchForm sf;

    public LegacyExcelExporter() {
        super("legacy_name", "legacy_code", "legacy_dept", "legacy_extraInfo");
    }

    @Override
    protected void fillResultItem(int row, Legacy item) {
        int col = 0;
        setValue(row, col++, item.getId().getName());
        setValue(row, col++, item.getId().getCode());
        setValue(row, col++, item.getId().getDept());
        setValue(row, col++, item.getExtraInfo());
    }

    @Override
    public void fillSearchCriteria(int row) {
        useCriteriaSheet();

        // todo
        // todo
        // todo
        setSelector(row++, 0, "legacy_extraInfo", sf.getExtraInfoSelector());
    }
}