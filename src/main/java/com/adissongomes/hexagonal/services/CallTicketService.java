package com.adissongomes.hexagonal.services;

import com.adissongomes.hexagonal.dto.Ticket;
import com.adissongomes.hexagonal.dto.TicketStatus;
import com.adissongomes.hexagonal.entities.TicketEntity;
import com.adissongomes.hexagonal.repositories.TicketRepository;
import com.adissongomes.hexagonal.services.usecases.CallTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CallTicketService implements CallTicket {

    private static final Logger log = LoggerFactory.getLogger(CallTicketService.class);
    private final TicketValidation validation;
    private final TicketRepository repository;

    public CallTicketService(TicketValidation validation, TicketRepository repository) {
        this.validation = validation;
        this.repository = repository;
    }

    @Override
    public Ticket call(int number) {
        Optional<TicketEntity> optional = repository.findById(number);
        log.info("{} found: {}", number, optional.isPresent());
        TicketEntity ticket = optional.orElseThrow(() -> new NullPointerException(number + " not found"));
        validation.allowUpdate(Ticket.fromEntity(ticket));
        ticket.setStatus(TicketStatus.CALLED.toString());
        repository.update(ticket);
        return Ticket.fromEntity(ticket);
    }
}
