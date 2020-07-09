package br.com.damsete.domain;

import br.com.damsete.domain.audit.Auditable;
import br.com.damsete.domain.notifications.Notifiable;

import java.time.LocalDateTime;

public abstract class IdentifiedDomainObject<T> extends Notifiable {

    protected T id;
    protected Integer version;
    protected Auditable auditable;

    public IdentifiedDomainObject() {
        super();
        this.version = 0;
    }

    public IdentifiedDomainObject(T id, Auditable auditable, Integer version) {
        this.id = id;
        this.version = version;
        this.auditable = auditable;
    }

    public T getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getCreatedBy() {
        return auditable == null ? null : auditable.getCreatedBy();
    }

    public LocalDateTime getCreatedAt() {
        return auditable == null ? null : auditable.getCreatedAt();
    }

    public String getModifiedBy() {
        return auditable == null ? null : auditable.getModifiedBy();
    }

    public LocalDateTime getModifiedAt() {
        return auditable == null ? null : auditable.getModifiedAt();
    }
}
