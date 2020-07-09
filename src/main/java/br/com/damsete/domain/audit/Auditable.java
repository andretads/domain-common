package br.com.damsete.domain.audit;

import java.time.LocalDateTime;

public class Auditable {

    private final String createdBy;
    private final LocalDateTime createdAt;
    private final String modifiedBy;
    private final LocalDateTime modifiedAt;

    public Auditable(String createdBy, LocalDateTime createdAt, String modifiedBy, LocalDateTime modifiedAt) {
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
}
