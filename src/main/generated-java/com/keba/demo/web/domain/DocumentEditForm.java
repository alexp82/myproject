/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EditForm.e.vm.java
 */
package com.keba.demo.web.domain;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.keba.demo.domain.Account;
import com.keba.demo.domain.Document;
import com.keba.demo.domain.Document_;
import com.keba.demo.repository.DocumentRepository;
import com.keba.demo.web.domain.support.GenericEditForm;
import com.keba.demo.web.domain.support.GenericToOneAssociation;
import com.keba.demo.web.faces.ConversationContextScoped;

/**
 * View Helper/Controller to edit {@link Document}.
 */
@Named
@ConversationContextScoped
public class DocumentEditForm extends GenericEditForm<Document, String> {
    @Inject
    protected DocumentController documentController;
    @Inject
    protected AccountController accountController;
    protected GenericToOneAssociation<Account, String> owner;

    @Inject
    public DocumentEditForm(DocumentRepository documentRepository, DocumentGraphLoader documentGraphLoader) {
        super(documentRepository, documentGraphLoader);
    }

    /**
     * The entity to edit/view.
     */
    public Document getDocument() {
        return getEntity();
    }

    public String print() {
        return documentController.print(getDocument());
    }

    @PostConstruct
    void setupOwnerActions() {
        owner = new GenericToOneAssociation<Account, String>(accountController, Document_.owner) {
            @Override
            protected Account get() {
                return getDocument().getOwner();
            }

            @Override
            protected void set(Account account) {
                getDocument().setOwner(account);
            }

            @NotNull
            @Override
            public Account getSelected() {
                return super.getSelected();
            }
        };
    }

    public GenericToOneAssociation<Account, String> getOwner() {
        return owner;
    }
}
