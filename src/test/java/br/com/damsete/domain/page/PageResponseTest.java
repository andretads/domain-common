package br.com.damsete.domain.page;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
class PageResponseTest {

    private final Faker faker = new Faker();

    @Test
    void testCreatePageResponse() {
        var content = Collections.singletonList("Object");
        var number = faker.number().randomDigit();
        var size = faker.number().randomDigit();
        var numberOfElements = faker.number().randomDigit();
        var totalPages = faker.number().randomDigit();
        var totalElements = faker.number().randomNumber();

        var response = new PageResponse<>(content, number, size, numberOfElements, totalPages, totalElements, true, false);

        assertThat(response.getContent()).hasSameSizeAs(content);
        assertEquals(number, response.getNumber());
        assertEquals(size, response.getSize());
        assertEquals(numberOfElements, response.getNumberOfElements());
        assertEquals(totalPages, response.getTotalPages());
        assertEquals(totalElements, response.getTotalElements());
        assertTrue(response.isFirst());
        assertFalse(response.isLast());
        assertNotNull(response.toString());
    }
}
