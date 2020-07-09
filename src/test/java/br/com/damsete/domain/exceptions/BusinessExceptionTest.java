package br.com.damsete.domain.exceptions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("unit")
class BusinessExceptionTest {

    @Test
    void testCreateBusinessException() {
        var message = "message";

        var exception = new BusinessException(message);

        assertEquals(message, exception.getMessage());
    }
}
