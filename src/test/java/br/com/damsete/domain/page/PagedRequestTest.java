package br.com.damsete.domain.page;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("unit")
class PagedRequestTest  {

    private final Faker faker = new Faker();

    @Test
    void testCreatePageRequest() {
        var page = faker.number().randomDigit();
        var size = faker.number().randomDigit();
        var sortBy = "id";
        var sortDir = "asc";
        var query = faker.name().firstName();

        var request = new PagedRequest(page, size, sortBy, sortDir, query);

        assertEquals(page, request.getPage());
        assertEquals(size, request.getSize());
        assertEquals(sortBy, request.getSortBy());
        assertEquals(sortDir, request.getSortDir());
        assertEquals(query, request.getQuery());
        assertNotNull(request.toString());
    }
}
