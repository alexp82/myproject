/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/domain/Entity.e.vm.java
 */
package com.keba.demo.domain;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Objects;

@Entity
@Table(name = "AUDIT_LOG")
public class AuditLog implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AuditLog.class);

    // Raw attributes
    private Integer id;
    private String author;
    private String event;
    private Date eventDate;
    private String stringAttribute1;
    private String stringAttribute2;
    private String stringAttribute3;

    // -- [id] ------------------------

    @Override
    @Column(name = "ID", precision = 10)
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public AuditLog id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isIdSet() {
        return id != null;
    }

    // -- [author] ------------------------

    @Size(max = 256)
    @Column(name = "AUTHOR", length = 256)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public AuditLog author(String author) {
        setAuthor(author);
        return this;
    }

    // -- [event] ------------------------

    @Size(max = 256)
    @Column(name = "EVENT", length = 256)
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public AuditLog event(String event) {
        setEvent(event);
        return this;
    }

    // -- [eventDate] ------------------------

    @Column(name = "EVENT_DATE", length = 23)
    @Temporal(TIMESTAMP)
    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public AuditLog eventDate(Date eventDate) {
        setEventDate(eventDate);
        return this;
    }

    // -- [stringAttribute1] ------------------------

    @Size(max = 256)
    @Column(name = "STRING_ATTRIBUTE_1", length = 256)
    public String getStringAttribute1() {
        return stringAttribute1;
    }

    public void setStringAttribute1(String stringAttribute1) {
        this.stringAttribute1 = stringAttribute1;
    }

    public AuditLog stringAttribute1(String stringAttribute1) {
        setStringAttribute1(stringAttribute1);
        return this;
    }

    // -- [stringAttribute2] ------------------------

    @Size(max = 256)
    @Column(name = "STRING_ATTRIBUTE_2", length = 256)
    public String getStringAttribute2() {
        return stringAttribute2;
    }

    public void setStringAttribute2(String stringAttribute2) {
        this.stringAttribute2 = stringAttribute2;
    }

    public AuditLog stringAttribute2(String stringAttribute2) {
        setStringAttribute2(stringAttribute2);
        return this;
    }

    // -- [stringAttribute3] ------------------------

    @Size(max = 256)
    @Column(name = "STRING_ATTRIBUTE_3", length = 256)
    public String getStringAttribute3() {
        return stringAttribute3;
    }

    public void setStringAttribute3(String stringAttribute3) {
        this.stringAttribute3 = stringAttribute3;
    }

    public AuditLog stringAttribute3(String stringAttribute3) {
        setStringAttribute3(stringAttribute3);
        return this;
    }

    /**
     * Apply the default values.
     */
    public AuditLog withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof AuditLog && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this AuditLog instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("author", getAuthor()) //
                .add("event", getEvent()) //
                .add("eventDate", getEventDate()) //
                .add("stringAttribute1", getStringAttribute1()) //
                .add("stringAttribute2", getStringAttribute2()) //
                .add("stringAttribute3", getStringAttribute3()) //
                .toString();
    }
}