/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/audit/AuditLogListener.p.vm.java
 */
package com.keba.demo.audit;

import static com.google.common.collect.Lists.newArrayList;
import static com.keba.demo.service.AuditEvent.Creation;
import static com.keba.demo.service.AuditEvent.Deletion;
import static com.keba.demo.service.AuditEvent.Modification;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.action.spi.AfterTransactionCompletionProcess;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.event.spi.AbstractEvent;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;

import com.keba.demo.context.UserContext;
import com.keba.demo.domain.AuditLog;
import com.keba.demo.domain.Identifiable;
import com.keba.demo.service.AuditEvent;
import com.keba.demo.service.AuditLogService;

@Named
public class AuditLogListener implements PreUpdateEventListener, PostDeleteEventListener, PostInsertEventListener {
    private static final long serialVersionUID = 1L;
    @Inject
    private AuditLogService auditLogService;
    protected List<String> skipProperties = newArrayList("version", "lastModificationAuthor", "lastModificationDate", "creationDate", "creationAuthor");
    protected List<String> skipClasses = newArrayList("AuditLog");

    protected void skipClasses(Class<?>... classesToBeIgnored) {
        for (Class<?> classToBeIgnored : classesToBeIgnored) {
            skipClasses.add(classToBeIgnored.getSimpleName());
        }
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        audit(event, Deletion, event.getEntity());
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        audit(event, Creation, event.getEntity());
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        String updateMessage = buildUpdateMessage(event);
        if (!updateMessage.isEmpty()) {
            audit(event, Modification, event.getEntity(), updateMessage);
        }
        return false;
    }

    private String buildUpdateMessage(PreUpdateEvent event) {
        String[] propertyNames = event.getPersister().getEntityMetamodel().getPropertyNames();
        Object[] oldStates = event.getOldState();
        Object[] newStates = event.getState();
        int index = 0;
        StringBuilder message = new StringBuilder(128);
        for (String propertyName : propertyNames) {
            message.append(message(propertyName, oldStates[index], newStates[index]));
            index++;
        }
        return message.toString();
    }

    private String message(String propertyName, Object oldState, Object newState) {
        if (newState instanceof Identifiable) {
            // no need to track objects
            return "";
        } else if (skipProperties.contains(propertyName)) {
            // no need to track version and lastModificationDates as they add no value
            return "";
        } else if (oldState == null && newState == null) {
            return "";
        } else if (oldState == null && newState != null) {
            return propertyName + " set to [" + newState + "]\n";
        } else if (oldState != null && newState == null) {
            return propertyName + " reseted to null\n";
        } else if (!oldState.toString().equals(newState.toString())) {
            return propertyName + " changed from [" + oldState.toString() + "] to [" + newState.toString() + "]\n";
        } else {
            return "";
        }
    }

    private void audit(AbstractEvent hibernateEvent, AuditEvent auditEvent, Object object) {
        audit(hibernateEvent, auditEvent, object, null);
    }

    private void audit(AbstractEvent hibernateEvent, AuditEvent auditEvent, Object object, String attribute) {
        String className = object.getClass().getSimpleName();
        if (skipClasses.contains(className)) {
            return;
        }

        AuditLog auditLog = new AuditLog();
        auditLog.setAuthor(UserContext.getUsername());
        auditLog.setEvent(auditEvent.name());
        auditLog.setEventDate(new Date());
        auditLog.setStringAttribute1(className);
        auditLog.setStringAttribute2(((Identifiable<?>) object).getId().toString());
        auditLog.setStringAttribute3(attribute);
        audit(hibernateEvent, auditLog);
    }

    private void audit(AbstractEvent hibernateEvent, final AuditLog auditLog) {
        hibernateEvent.getSession().getActionQueue().registerProcess(new AfterTransactionCompletionProcess() {
            @Override
            public void doAfterTransactionCompletion(boolean success, SessionImplementor session) {
                if (success) {
                    auditLogService.log(auditLog);
                }
            }
        });
    }
}