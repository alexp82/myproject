/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/support/ByteArrayStreamedContent.p.vm.java
 */
package com.keba.demo.web.domain.support;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.primefaces.model.StreamedContent;

import com.keba.demo.web.util.DownloadUtil;

/**
 * StreamedContent that lazily loads the binary content.
 */
public abstract class ByteArrayStreamedContent implements StreamedContent {
    private String contentType = "application/download";
    private String name;
    private String contentEncoding;

    @Override
    public InputStream getStream() {
        DownloadUtil.forceResponseHeaderForDownload();
        return new ByteArrayInputStream(getByteArray());
    }

    /**
     * Lazily load the binary content.
     */
    protected abstract byte[] getByteArray();

    @Override
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    @Override
    public String getContentEncoding() {
        return contentEncoding;
    }
}