/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/domain/Entity.e.vm.java
 */
package com.keba.demo.domain.more;

import static javax.persistence.TemporalType.DATE;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Objects;
import com.keba.demo.domain.Identifiable;
import com.keba.demo.domain.IdentifiableHashBuilder;

@Entity
@Table(name = "MORE_TYPES_DEMO")
public class MoreTypesDemo implements Identifiable<BigDecimal>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MoreTypesDemo.class);

    // Raw attributes
    private BigDecimal id;
    private Integer numberInt;
    private Long numberLong;
    private Double numberDouble;
    private Float numberFloat;
    private BigInteger numberBigInteger;
    private BigDecimal numberBigDecimal;
    private Date dateJavaTemporalDate;
    private Date dateJavaTemporalTimestamp;
    private LocalDate dateJoda;
    private LocalDateTime dateTimeJoda;
    private Integer version;

    // -- [id] ------------------------

    @Override
    @Column(name = "ID", precision = 15, scale = 5)
    @GeneratedValue
    @Id
    public BigDecimal getId() {
        return id;
    }

    @Override
    public void setId(BigDecimal id) {
        this.id = id;
    }

    public MoreTypesDemo id(BigDecimal id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isIdSet() {
        return id != null;
    }

    // -- [numberInt] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "NUMBER_INT", precision = 10)
    public Integer getNumberInt() {
        return numberInt;
    }

    public void setNumberInt(Integer numberInt) {
        this.numberInt = numberInt;
    }

    public MoreTypesDemo numberInt(Integer numberInt) {
        setNumberInt(numberInt);
        return this;
    }

    // -- [numberLong] ------------------------

    @Digits(integer = 19, fraction = 0)
    @Column(name = "NUMBER_LONG", precision = 19)
    public Long getNumberLong() {
        return numberLong;
    }

    public void setNumberLong(Long numberLong) {
        this.numberLong = numberLong;
    }

    public MoreTypesDemo numberLong(Long numberLong) {
        setNumberLong(numberLong);
        return this;
    }

    // -- [numberDouble] ------------------------

    @Digits(integer = 17, fraction = 0)
    @Column(name = "NUMBER_DOUBLE", precision = 17)
    public Double getNumberDouble() {
        return numberDouble;
    }

    public void setNumberDouble(Double numberDouble) {
        this.numberDouble = numberDouble;
    }

    public MoreTypesDemo numberDouble(Double numberDouble) {
        setNumberDouble(numberDouble);
        return this;
    }

    // -- [numberFloat] ------------------------

    @Digits(integer = 7, fraction = 0)
    @Column(name = "NUMBER_FLOAT", precision = 7)
    public Float getNumberFloat() {
        return numberFloat;
    }

    public void setNumberFloat(Float numberFloat) {
        this.numberFloat = numberFloat;
    }

    public MoreTypesDemo numberFloat(Float numberFloat) {
        setNumberFloat(numberFloat);
        return this;
    }

    // -- [numberBigInteger] ------------------------

    @Digits(integer = 20, fraction = 0)
    @Column(name = "NUMBER_BIG_INTEGER", precision = 20)
    public BigInteger getNumberBigInteger() {
        return numberBigInteger;
    }

    public void setNumberBigInteger(BigInteger numberBigInteger) {
        this.numberBigInteger = numberBigInteger;
    }

    public MoreTypesDemo numberBigInteger(BigInteger numberBigInteger) {
        setNumberBigInteger(numberBigInteger);
        return this;
    }

    // -- [numberBigDecimal] ------------------------

    @Digits(integer = 18, fraction = 2)
    @Column(name = "NUMBER_BIG_DECIMAL", precision = 20, scale = 2)
    public BigDecimal getNumberBigDecimal() {
        return numberBigDecimal;
    }

    public void setNumberBigDecimal(BigDecimal numberBigDecimal) {
        this.numberBigDecimal = numberBigDecimal;
    }

    public MoreTypesDemo numberBigDecimal(BigDecimal numberBigDecimal) {
        setNumberBigDecimal(numberBigDecimal);
        return this;
    }

    // -- [dateJavaTemporalDate] ------------------------

    @Column(name = "DATE_JAVA_TEMPORAL_DATE", length = 8)
    @Temporal(DATE)
    public Date getDateJavaTemporalDate() {
        return dateJavaTemporalDate;
    }

    public void setDateJavaTemporalDate(Date dateJavaTemporalDate) {
        this.dateJavaTemporalDate = dateJavaTemporalDate;
    }

    public MoreTypesDemo dateJavaTemporalDate(Date dateJavaTemporalDate) {
        setDateJavaTemporalDate(dateJavaTemporalDate);
        return this;
    }

    // -- [dateJavaTemporalTimestamp] ------------------------

    @Column(name = "DATE_JAVA_TEMPORAL_TIMESTAMP", length = 23)
    @Temporal(TIMESTAMP)
    public Date getDateJavaTemporalTimestamp() {
        return dateJavaTemporalTimestamp;
    }

    public void setDateJavaTemporalTimestamp(Date dateJavaTemporalTimestamp) {
        this.dateJavaTemporalTimestamp = dateJavaTemporalTimestamp;
    }

    public MoreTypesDemo dateJavaTemporalTimestamp(Date dateJavaTemporalTimestamp) {
        setDateJavaTemporalTimestamp(dateJavaTemporalTimestamp);
        return this;
    }

    // -- [dateJoda] ------------------------

    @Column(name = "DATE_JODA", length = 8)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    public LocalDate getDateJoda() {
        return dateJoda;
    }

    public void setDateJoda(LocalDate dateJoda) {
        this.dateJoda = dateJoda;
    }

    public MoreTypesDemo dateJoda(LocalDate dateJoda) {
        setDateJoda(dateJoda);
        return this;
    }

    // -- [dateTimeJoda] ------------------------

    @Column(name = "DATE_TIME_JODA", length = 23)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    public LocalDateTime getDateTimeJoda() {
        return dateTimeJoda;
    }

    public void setDateTimeJoda(LocalDateTime dateTimeJoda) {
        this.dateTimeJoda = dateTimeJoda;
    }

    public MoreTypesDemo dateTimeJoda(LocalDateTime dateTimeJoda) {
        setDateTimeJoda(dateTimeJoda);
        return this;
    }

    // -- [version] ------------------------

    @Column(name = "VERSION", precision = 10)
    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public MoreTypesDemo version(Integer version) {
        setVersion(version);
        return this;
    }

    /**
     * Apply the default values.
     */
    public MoreTypesDemo withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof MoreTypesDemo && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this MoreTypesDemo instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("numberInt", getNumberInt()) //
                .add("numberLong", getNumberLong()) //
                .add("numberDouble", getNumberDouble()) //
                .add("numberFloat", getNumberFloat()) //
                .add("numberBigInteger", getNumberBigInteger()) //
                .add("numberBigDecimal", getNumberBigDecimal()) //
                .add("dateJavaTemporalDate", getDateJavaTemporalDate()) //
                .add("dateJavaTemporalTimestamp", getDateJavaTemporalTimestamp()) //
                .add("dateJoda", getDateJoda()) //
                .add("dateTimeJoda", getDateTimeJoda()) //
                .add("version", getVersion()) //
                .toString();
    }
}