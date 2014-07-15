/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/LazyDataModel.e.vm.java
 */
package com.keba.demo.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import com.keba.demo.domain.Legacy;
import com.keba.demo.domain.LegacyPk;
import com.keba.demo.repository.LegacyRepository;
import com.keba.demo.web.domain.support.GenericLazyDataModel;
import com.keba.demo.web.faces.ConversationContextScoped;

/**
 * Provide PrimeFaces {@link LazyDataModel} for {@link Legacy}
 */
@Named
@ConversationContextScoped
public class LegacyLazyDataModel extends GenericLazyDataModel<Legacy, LegacyPk, LegacySearchForm> {
    private static final long serialVersionUID = 1L;

    @Inject
    public LegacyLazyDataModel(LegacyRepository legacyRepository, LegacyController legacyController, LegacySearchForm legacySearchForm,
            LegacyExcelExporter legacyExcelExporter) {
        super(legacyRepository, legacyController, legacySearchForm, legacyExcelExporter);
    }
}