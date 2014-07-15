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

import com.keba.demo.domain.Account;
import com.keba.demo.domain.Book;
import com.keba.demo.domain.Book_;
import com.keba.demo.repository.BookRepository;
import com.keba.demo.web.domain.support.GenericEditForm;
import com.keba.demo.web.domain.support.GenericToOneAssociation;
import com.keba.demo.web.faces.ConversationContextScoped;

/**
 * View Helper/Controller to edit {@link Book}.
 */
@Named
@ConversationContextScoped
public class BookEditForm extends GenericEditForm<Book, Integer> {
    @Inject
    protected BookController bookController;
    @Inject
    protected AccountController accountController;
    protected GenericToOneAssociation<Account, String> owner;

    @Inject
    public BookEditForm(BookRepository bookRepository, BookGraphLoader bookGraphLoader) {
        super(bookRepository, bookGraphLoader);
    }

    /**
     * The entity to edit/view.
     */
    public Book getBook() {
        return getEntity();
    }

    public String print() {
        return bookController.print(getBook());
    }

    @PostConstruct
    void setupOwnerActions() {
        owner = new GenericToOneAssociation<Account, String>(accountController, Book_.owner) {
            @Override
            protected Account get() {
                return getBook().getOwner();
            }

            @Override
            protected void set(Account account) {
                getBook().setOwner(account);
            }
        };
    }

    public GenericToOneAssociation<Account, String> getOwner() {
        return owner;
    }
}