/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/FileDownload.e.vm.java
 */
package com.keba.demo.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.primefaces.model.StreamedContent;

import com.keba.demo.domain.Document;
import com.keba.demo.domain.Document_;
import com.keba.demo.repository.DocumentRepository;
import com.keba.demo.web.domain.support.ByteArrayStreamedContent;

/**
 * Stateless controller to download {@link Document} binaries 
 */
@Named
@Singleton
public class DocumentFileDownload {
    @Inject
    private DocumentRepository documentRepository;

    /**
     * Primefaces support for documentBinary file download.
     */
    public StreamedContent getDocumentBinaryStream(final Document document) {
        // check whether the binary is null WITHOUT downloading it.
        if (document.isIdSet()) {
            if (documentRepository.isPropertyNull(document.getId(), Document_.documentBinary)) {
                return null;
            }
        } else if (document.getDocumentBinary() == null) {
            return null;
        }

        ByteArrayStreamedContent basc = new ByteArrayStreamedContent() {
            @Override
            public byte[] getByteArray() {
                return documentRepository.getDocumentBinary(document);
            }
        };
        basc.setContentType(document.getDocumentContentType());
        basc.setName(document.getDocumentFileName());
        return basc;
    }
}