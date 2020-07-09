package br.com.damsete.domain.audit;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuditableTest {

    private final Faker faker = new Faker();

    @Test
    void testCreateAuditable() {
        var createdBy = faker.name().username();
        var createdAt = LocalDateTime.now();
        var modifiedBy = faker.name().username();
        var modifiedAt = LocalDateTime.now();

        var auditable = new Auditable(createdBy, createdAt, modifiedBy, modifiedAt);

        assertEquals(createdBy, auditable.getCreatedBy());
        assertEquals(createdAt, auditable.getCreatedAt());
        assertEquals(modifiedBy, auditable.getModifiedBy());
        assertEquals(modifiedAt, auditable.getModifiedAt());
    }
}
