package com.adissongomes.hexagonal.repositories;

import com.adissongomes.hexagonal.entities.TicketEntity;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TicketMemoryRepository implements TicketRepository {
    private final Map<Integer, TicketEntity> data = new HashMap<>();
    private final AtomicInteger last = new AtomicInteger(1);

    @Override
    public TicketEntity save(TicketEntity ticketEntity) {
        Objects.requireNonNull(ticketEntity);
        Instant now = Instant.now();
        ticketEntity.setCreatedAt(now);
        ticketEntity.setUpdatedAt(now);
        ticketEntity.setNumber(last.getAndIncrement());
        data.put(ticketEntity.getNumber(), ticketEntity);
        return ticketEntity;
    }

    @Override
    public Optional<TicketEntity> findById(int ticketNumber) {
        return Optional.of(data.get(ticketNumber));
    }

    @Override
    public void update(TicketEntity ticketEntity) {
        if (ticketEntity == null || ticketEntity.getNumber() <= 0) {
            throw new IllegalArgumentException("Ticket#number cannot be less or equal to zero");
        }
        ticketEntity.setUpdatedAt(Instant.now());
        data.replace(ticketEntity.getNumber(), ticketEntity);
    }
}
