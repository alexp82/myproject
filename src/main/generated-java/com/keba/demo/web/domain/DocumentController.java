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

import com.keba.demo.domain.Document;
import com.keba.demo.printer.DocumentPrinter;
import com.keba.demo.repository.DocumentRepository;
import com.keba.demo.web.domain.support.GenericController;
import com.keba.demo.web.permission.DocumentPermission;

/**
 * Stateless controller for {@link Document} conversation start.
 */
@Named
@Singleton
public class DocumentController extends GenericController<Document, String> {
    public static final String DOCUMENT_EDIT_URI = "/domain/documentEdit.faces";
    public static final String DOCUMENT_SELECT_URI = "/domain/documentSelect.faces";

    @Inject
    public DocumentController(DocumentRepository documentRepository, DocumentPermission documentPermission, DocumentPrinter documentPrinter) {
        super(documentRepository, documentPermission, documentPrinter, DOCUMENT_SELECT_URI, DOCUMENT_EDIT_URI);
    }

    public DocumentFileUpload getDocumentFileUpload(Document document) {
        return new DocumentFileUpload(document);
    }
}