package br.com.damsete.domain;

import br.com.damsete.domain.audit.Auditable;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("unit")
class IdentifiedDomainObjectTest {

    private final Faker faker = new Faker();

    @Test
    void testCreateDomainObject() {
        var name = faker.name().name();

        var pojo = new Pojo(name);

        assertNotNull(pojo.getId());
        assertEquals(name, pojo.getName());
    }

    @Test
    void testLoadDomainObject() {
        var id = UUID.randomUUID();
        var auditable = new Auditable(faker.name().username(), LocalDateTime.now(),
                faker.name().username(), LocalDateTime.now());
        var version = 0;
        var name = faker.name().name();

        var pojo = new Pojo(id, auditable, version, name);

        assertEquals(id, pojo.getId());
        assertEquals(auditable.getCreatedBy(), pojo.getCreatedBy());
        assertEquals(auditable.getCreatedAt(), pojo.getCreatedAt());
        assertEquals(auditable.getModifiedBy(), pojo.getModifiedBy());
        assertEquals(auditable.getModifiedAt(), pojo.getModifiedAt());
        assertEquals(version, pojo.getVersion());
        assertEquals(name, pojo.getName());
    }
}
