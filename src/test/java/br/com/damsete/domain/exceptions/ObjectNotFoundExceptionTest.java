package br.com.damsete.domain.exceptions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("unit")
class ObjectNotFoundExceptionTest {

    @Test
    void testCreateObjectNotFoundException() {
        var message = "message";

        var exception = new ObjectNotFoundException(message);

        assertEquals(message, exception.getMessage());
    }
}
