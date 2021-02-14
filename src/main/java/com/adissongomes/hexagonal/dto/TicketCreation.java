package com.adissongomes.hexagonal.dto;

public class TicketCreation {
    private final String name;

    public TicketCreation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
