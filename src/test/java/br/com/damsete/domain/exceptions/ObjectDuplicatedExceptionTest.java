package br.com.damsete.domain.exceptions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("unit")
class ObjectDuplicatedExceptionTest {

    @Test
    void testCreateObjectDuplicatedException() {
        var message = "message";

        var exception = new ObjectDuplicatedException(message);

        assertEquals(message, exception.getMessage());
    }
}
