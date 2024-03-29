/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/service/AuditLogService.p.vm.java
 */
package com.keba.demo.service;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;

import com.keba.demo.context.UserContext;
import com.keba.demo.domain.AuditLog;

@Named
@Singleton
@Lazy(false)
public class AuditLogService {
    private static final Logger log = LoggerFactory.getLogger(AuditLogService.class);
    private static final int DEFAULT_BATCH_INSERT_SIZE = 50;
    @Inject
    private SessionFactory sessionFactory;
    protected BlockingQueue<AuditLog> queue = new LinkedBlockingQueue<AuditLog>(1000);
    protected int batchInsertSize = DEFAULT_BATCH_INSERT_SIZE;

    @Scheduled(fixedDelay = 1 * 1000)
    public void batchInsert() {
        List<AuditLog> httpEvents = newArrayList();
        int size = queue.drainTo(httpEvents, batchInsertSize);
        if (size != 0) {
            batchInsert(httpEvents);
        }
    }

    public void event(AuditEvent auditEvent) {
        event(auditEvent, null);
    }

    public void event(AuditEvent auditEvent, String string1) {
        event(auditEvent, string1, null);
    }

    public void event(AuditEvent auditEvent, String string1, String string2) {
        event(auditEvent, string1, string2, null);
    }

    public void event(AuditEvent auditEvent, String string1, String string2, String string3) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAuthor(UserContext.getUsername());
        auditLog.setEvent(auditEvent.name());
        auditLog.setStringAttribute1(string1);
        auditLog.setStringAttribute2(string2);
        auditLog.setStringAttribute3(string3);
        log(auditLog);
    }

    public void log(AuditLog auditLog) {
        setupDefaults(auditLog);
        queue.add(auditLog);
    }

    private void setupDefaults(AuditLog auditLog) {
        if (auditLog.getAuthor() == null) {
            auditLog.setAuthor(UserContext.getUsername());
        }
        if (auditLog.getEventDate() == null) {
            auditLog.setEventDate(new Date());
        }
    }

    private void batchInsert(List<AuditLog> auditLogs) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            for (AuditLog auditLog : auditLogs) {
                session.save(auditLog);
            }
            session.flush();
            transaction.commit();
            log.debug("Added {} AuditLog in database", auditLogs.size());
        } catch (Exception e) {
            log.error("Error while inserting AuditLog", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}