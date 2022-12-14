package com.example.lastmodifiedproblem;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LastmodifiedproblemApplicationTests {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void persistsAndLoadsInstant() {
        EntityWithInstant entity = new EntityWithInstant();
        entity.id = UUID.randomUUID();
        entity.instant = Instant.now();

        em.persist(entity);

        em.flush();
        em.clear();

        EntityWithInstant reloaded = em.find(EntityWithInstant.class, entity.id);

        assertThat(entity.instant).isEqualTo(reloaded.instant);
    }
}
