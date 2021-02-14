package com.adissongomes.hexagonal.dto;

import com.adissongomes.hexagonal.entities.TicketEntity;

import java.time.Instant;

public class Ticket {
    private int number;
    private String name;
    private TicketStatus status;
    private Instant createdAt;
    private Instant udpatedAt;

    public Ticket(int number, String name, TicketStatus status,
                  Instant createdAt, Instant udpatedAt) {
        this.number = number;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
        this.udpatedAt = udpatedAt;
    }

    public Ticket() {
    }

    public static Ticket fromEntity(TicketEntity ticketEntity) {
        return new Ticket(ticketEntity.getNumber(), ticketEntity.getName(),
                TicketStatus.valueOf(ticketEntity.getStatus()),
                ticketEntity.getCreatedAt(), ticketEntity.getUpdatedAt());
    }

    public TicketEntity toEntity() {
        return new TicketEntity(number, name,
                status.toString(), null, null);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUdpatedAt() {
        return udpatedAt;
    }

    public void setUdpatedAt(Instant udpatedAt) {
        this.udpatedAt = udpatedAt;
    }
}
