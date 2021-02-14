package com.adissongomes.hexagonal.services;

import com.adissongomes.hexagonal.dto.Ticket;
import com.adissongomes.hexagonal.dto.TicketCreation;
import com.adissongomes.hexagonal.dto.TicketStatus;
import com.adissongomes.hexagonal.entities.TicketEntity;
import com.adissongomes.hexagonal.repositories.TicketRepository;
import com.adissongomes.hexagonal.services.usecases.CreateTicket;
import com.adissongomes.hexagonal.services.usecases.FinishTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinishTicketService implements FinishTicket {

    private static final Logger log = LoggerFactory.getLogger(FinishTicketService.class);
    private final TicketRepository repository;

    public FinishTicketService(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ticket finish(int number) {
        Optional<TicketEntity> optional = repository.findById(number);
        TicketEntity ticket = optional.orElseThrow(() -> new NullPointerException(number + " not found"));
        ticket.setStatus(TicketStatus.FINISHED.toString());
        repository.update(ticket);
        return Ticket.fromEntity(ticket);
    }

}
