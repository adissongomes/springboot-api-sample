package com.adissongomes.hexagonal.repositories;

import com.adissongomes.hexagonal.entities.TicketEntity;

import java.util.Optional;

public interface TicketRepository {
    TicketEntity save(TicketEntity ticketEntity);
    Optional<TicketEntity> findById(int ticketNumber);
    void update(TicketEntity entity);
}
