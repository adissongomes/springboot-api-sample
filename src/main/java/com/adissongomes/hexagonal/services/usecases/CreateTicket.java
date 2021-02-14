package com.adissongomes.hexagonal.services.usecases;

import com.adissongomes.hexagonal.dto.Ticket;
import com.adissongomes.hexagonal.dto.TicketCreation;

public interface CreateTicket {
    Ticket createTicket(TicketCreation ticketCreation);
}
