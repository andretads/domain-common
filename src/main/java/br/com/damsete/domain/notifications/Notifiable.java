package br.com.damsete.domain.notifications;

import br.com.damsete.domain.exceptions.NotificationException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public abstract class Notifiable {

    private final List<Notification> notifications;

    protected Notifiable() {
        this.notifications = newArrayList();
    }

    public Notifiable addNotification(String code, Object... args) {
        return addNotification(new Notification(code, args));
    }

    public Notifiable addNotification(Notification notification) {
        return addNotification(Collections.singletonList(notification));
    }

    public Notifiable addNotification(List<Notification> notifications) {
        this.notifications.addAll(notifications);
        return this;
    }

    public Notifiable addNotification(Notifiable notifiable) {
        return addNotification(notifiable.getNotifications());
    }

    public Notifiable addNotification(Notifiable... notifiable) {
        Arrays.asList(notifiable).forEach(this::addNotification);
        return this;
    }

    public List<Notification> getNotifications() {
        return Collections.unmodifiableList(this.notifications);
    }

    public boolean valid() {
        return getNotifications().isEmpty();
    }

    public boolean invalid() {
        return !valid();
    }

    public void verify() {
        if (invalid()) {
            throw new NotificationException(getNotifications());
        }
    }
}
