package com.adissongomes.hexagonal.services.usecases;

import com.adissongomes.hexagonal.dto.Ticket;
import com.adissongomes.hexagonal.dto.TicketCreation;
import com.adissongomes.hexagonal.dto.TicketStatus;
import org.springframework.util.StringUtils;

public interface TicketValidator {
    default void allowCreation(TicketCreation ticketCreation) {
        if (ticketCreation == null || StringUtils.hasText(ticketCreation.getName())) {
            throw new IllegalArgumentException("It is required a ticket with a name");
        }
    }
    default void allowUpdate(Ticket ticket) {
        if (ticket.getStatus() != TicketStatus.FINISHED)
            throw new IllegalArgumentException("Ticket " + ticket.getNumber() + " was concluded");
    }
}
