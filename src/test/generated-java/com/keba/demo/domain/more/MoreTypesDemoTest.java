/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/domain/ModelTest.e.vm.java
 */
package com.keba.demo.domain.more;

import static org.fest.assertions.Assertions.assertThat;

import java.io.*;
import java.util.*;

import org.junit.Test;

import com.keba.demo.util.ValueGenerator;

/**
 * Basic tests for MoreTypesDemo
 */
@SuppressWarnings("unused")
public class MoreTypesDemoTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        MoreTypesDemo model = new MoreTypesDemo();
        assertThat(model.isIdSet()).isFalse();
    }

    @Test
    public void isIdSetReturnsTrue() {
        MoreTypesDemo model = new MoreTypesDemo();
        model.setId(ValueGenerator.getUniqueBigDecimal());
        assertThat(model.getId()).isNotNull();
        assertThat(model.isIdSet()).isTrue();
    }

    /*
     public void equalsUsingPk() {
     MoreTypesDemo model1 = new MoreTypesDemo();
     MoreTypesDemo model2 = new MoreTypesDemo();

     BigDecimal id = ValueGenerator.getUniqueBigDecimal();
     model1.setId(id);
     model2.setId(id);

     model1.setNumberInt(1);
     model2.setNumberInt(1);

     model1.setNumberLong(1l);
     model2.setNumberLong(1l);

     model1.setNumberDouble(1d);
     model2.setNumberDouble(1d);

     model1.setNumberFloat(1f);
     model2.setNumberFloat(1f);

     model1.setNumberBigInteger(BigInteger.ONE);
     model2.setNumberBigInteger(BigInteger.ONE);

     model1.setNumberBigDecimal(BigDecimal.ONE);
     model2.setNumberBigDecimal(BigDecimal.ONE);

     model1.setDateJavaTemporalDate(new Date());
     model2.setDateJavaTemporalDate(new Date());

     model1.setDateJavaTemporalTimestamp(new Date());
     model2.setDateJavaTemporalTimestamp(new Date());

     model1.setDateJoda(new org.joda.time.LocalDate());
     model2.setDateJoda(new org.joda.time.LocalDate());

     model1.setDateTimeJoda(new org.joda.time.LocalDateTime());
     model2.setDateTimeJoda(new org.joda.time.LocalDateTime());

     model1.setVersion(1);
     model2.setVersion(1);
     assertThat(model1.isIdSet()).isTrue();
     assertThat(model2.isIdSet()).isTrue();
     assertThat(model1.hashCode()).isEqualTo(model2.hashCode());
     assertThat(model1).isEqualTo(model2);
     assertThat(model2).isEqualTo(model1);
     }
     */
}