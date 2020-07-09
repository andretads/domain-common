package br.com.damsete.domain.exceptions;

import br.com.damsete.domain.notifications.Notification;

import java.util.Collections;
import java.util.List;

public class NotificationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final transient List<Notification> notifications;

    public NotificationException(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Notification> getNotifications() {
        return Collections.unmodifiableList(notifications);
    }
}
