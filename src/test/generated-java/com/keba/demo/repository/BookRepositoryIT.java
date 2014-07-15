/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/service/RepositoryIT.e.vm.java
 */
package com.keba.demo.repository;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.keba.demo.domain.Book;
import com.keba.demo.domain.Book_;
import com.keba.demo.repository.support.SearchParameters;

/**
 * Integration test on BookRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class BookRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(BookRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private BookRepository bookRepository;

    @Inject
    private BookGenerator bookGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Book book = bookGenerator.getBook();

        // add it to a Set before saving (force equals/hashcode)
        Set<Book> set = newHashSet(book, book);
        assertThat(set).hasSize(1);

        bookRepository.save(book);
        entityManager.flush();

        // reload it from cache and check equality
        Book model = new Book();
        model.setId(book.getId());
        assertThat(book).isEqualTo(bookRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(book.getId()).isEqualTo(bookRepository.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(book).isNotEqualTo(bookRepository.get(model));
    }

    @Test
    @Rollback
    public void saveAndGetWithExplicitNullPropertySelector() {
        Book book = bookGenerator.getBook();

        // add it to a Set before saving (force equals/hashcode)
        Set<Book> set = newHashSet(book, book);
        assertThat(set).hasSize(1);

        // explicitly set toOne relationship to null
        book.setOwner(null);

        bookRepository.save(book);
        entityManager.flush();

        // clear cache to force reload from db
        entityManager.clear();

        SearchParameters searchParameters = new SearchParameters() //
                .caseInsensitive() //
                .anywhere() //
                .property(Book_.owner, (Object) null);

        List<Book> elements = bookRepository.find(searchParameters);
        assertThat(elements).isNotEmpty();
        for (Book element : elements) {
            assertThat(element.getOwner()).isNull();
        }
    }
}