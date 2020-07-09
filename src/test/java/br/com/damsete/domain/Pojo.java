package br.com.damsete.domain;

import br.com.damsete.domain.audit.Auditable;

import java.util.UUID;

public class Pojo extends IdentifiedDomainObject<UUID> {

    private final String name;

    public Pojo(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public Pojo(UUID id, Auditable auditable, Integer version, String name) {
        super(id, auditable, version);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
