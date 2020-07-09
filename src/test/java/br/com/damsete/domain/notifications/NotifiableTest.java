package br.com.damsete.domain.notifications;

import br.com.damsete.domain.exceptions.NotificationException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
class NotifiableTest extends Notifiable {

    @Test
    void testAddNotificationForOneNotifiable() {
        Name name = new Name();
        Customer customer = new Customer();

        addNotification(name);
        addNotification(customer);

        assertFalse(valid());
        assertThat(getNotifications()).hasSize(2);
    }

    @Test
    void testAddNotificationForMultipleNotifiable() {
        Name name = new Name();
        Customer customer = new Customer();

        addNotification(name, customer);

        assertFalse(valid());
        assertThat(getNotifications()).hasSize(2);
    }

    @Test
    void testOkNotifiable() {
        Invoice invoice = new Invoice();

        addNotification(invoice);

        verify();

        assertTrue(valid());
        assertThat(getNotifications()).isEmpty();
    }

    @Test
    void testHandleException() {
        Name name = new Name();
        Customer customer = new Customer();

        addNotification(name, customer);

        NotificationException exception = assertThrows(NotificationException.class, this::verify);

        assertThat(exception.getNotifications()).isNotEmpty();
    }

    static class Customer extends Notifiable {

        Customer() {
            addNotification("Test", "Testing");
        }
    }

    static class Name extends Notifiable {

        Name() {
            addNotification("Test", "Testing");
        }
    }

    static class Invoice extends Notifiable {

        Invoice() {
            super();
        }
    }
}
