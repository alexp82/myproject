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

import com.keba.demo.domain.Document;

/**
 * Integration test on DocumentRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class DocumentRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(DocumentRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private DocumentRepository documentRepository;

    @Inject
    private DocumentGenerator documentGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Document document = documentGenerator.getDocument();

        // add it to a Set before saving (force equals/hashcode)
        Set<Document> set = newHashSet(document, document);
        assertThat(set).hasSize(1);

        documentRepository.save(document);
        entityManager.flush();

        // reload it from cache and check equality
        Document model = new Document();
        model.setId(document.getId());
        assertThat(document).isEqualTo(documentRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(document.getId()).isEqualTo(documentRepository.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(document).isNotEqualTo(documentRepository.get(model));
    }

}