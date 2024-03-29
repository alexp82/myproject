/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/ExcelExporter.e.vm.java
 */
package com.keba.demo.web.domain.more;

import javax.inject.Inject;
import javax.inject.Named;

import com.keba.demo.domain.more.MoreTypesDemo;
import com.keba.demo.web.domain.support.GenericExcelExporter;
import com.keba.demo.web.faces.ConversationContextScoped;

/**
 * Exports to excel document {@link MoreTypesDemo} search criteria and result. 
 */
@Named
@ConversationContextScoped
public class MoreTypesDemoExcelExporter extends GenericExcelExporter<MoreTypesDemo> {
    @Inject
    protected MoreTypesDemoSearchForm sf;

    public MoreTypesDemoExcelExporter() {
        super("moreTypesDemo_numberInt", "moreTypesDemo_numberLong", "moreTypesDemo_numberDouble", "moreTypesDemo_numberFloat",
                "moreTypesDemo_numberBigInteger", "moreTypesDemo_numberBigDecimal");
    }

    @Override
    protected void fillResultItem(int row, MoreTypesDemo item) {
        int col = 0;
        setValue(row, col++, item.getNumberInt());
        setValue(row, col++, item.getNumberLong());
        setValue(row, col++, item.getNumberDouble());
        setValue(row, col++, item.getNumberFloat());
        setValue(row, col++, item.getNumberBigInteger());
        setValue(row, col++, item.getNumberBigDecimal());
    }

    @Override
    public void fillSearchCriteria(int row) {
        useCriteriaSheet();

        setRangeNumber(row++, 0, "moreTypesDemo_numberInt", sf.getNumberIntRange());
        setRangeNumber(row++, 0, "moreTypesDemo_numberLong", sf.getNumberLongRange());
        setRangeNumber(row++, 0, "moreTypesDemo_numberDouble", sf.getNumberDoubleRange());
        setRangeNumber(row++, 0, "moreTypesDemo_numberFloat", sf.getNumberFloatRange());
        setRangeNumber(row++, 0, "moreTypesDemo_numberBigInteger", sf.getNumberBigIntegerRange());
        setRangeNumber(row++, 0, "moreTypesDemo_numberBigDecimal", sf.getNumberBigDecimalRange());
        setRangeDate(row++, 0, "moreTypesDemo_dateJavaTemporalDate", sf.getDateJavaTemporalDateRange());
        setRangeDateTime(row++, 0, "moreTypesDemo_dateJavaTemporalTimestamp", sf.getDateJavaTemporalTimestampRange());
        setRangeLocalDate(row++, 0, "moreTypesDemo_dateJoda", sf.getDateJodaRange());
        setRangeLocalDateTime(row++, 0, "moreTypesDemo_dateTimeJoda", sf.getDateTimeJodaRange());
    }
}