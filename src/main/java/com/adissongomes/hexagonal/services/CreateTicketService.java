package com.adissongomes.hexagonal.services;

import com.adissongomes.hexagonal.dto.Ticket;
import com.adissongomes.hexagonal.dto.TicketCreation;
import com.adissongomes.hexagonal.dto.TicketStatus;
import com.adissongomes.hexagonal.entities.TicketEntity;
import com.adissongomes.hexagonal.repositories.TicketRepository;
import com.adissongomes.hexagonal.services.usecases.CallTicket;
import com.adissongomes.hexagonal.services.usecases.CreateTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class CreateTicketService implements CreateTicket {

    private static final Logger log = LoggerFactory.getLogger(CreateTicketService.class);
    private final TicketValidation validation;
    private final TicketRepository repository;

    public CreateTicketService(TicketValidation validation, TicketRepository repository) {
        this.validation = validation;
        this.repository = repository;
    }

    @Override
    public Ticket create(TicketCreation ticketCreation) {
        validation.allowCreation(ticketCreation);
        TicketEntity ticket = new TicketEntity();
        ticket.setName(ticketCreation.getName());
        ticket.setStatus(TicketStatus.WAITING.toString());
        ticket = repository.save(ticket);
        return Ticket.fromEntity(ticket);
    }

}
