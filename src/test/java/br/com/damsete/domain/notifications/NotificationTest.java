package br.com.damsete.domain.notifications;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("unit")
class NotificationTest  {

    private final Faker faker = new Faker();

    @Test
    void testGetCode() {
        var code = faker.pokemon().name();

        var notification = new Notification(code);

        assertEquals(code, notification.getCode());
    }

    @Test
    void testGetArgs() {
        var code = faker.pokemon().name();
        var args = Collections.singletonList("Object");

        var notification = new Notification(code, args);

        assertEquals(code, notification.getCode());
        assertThat(notification.getArgs()).hasSameSizeAs(args);
    }
}
