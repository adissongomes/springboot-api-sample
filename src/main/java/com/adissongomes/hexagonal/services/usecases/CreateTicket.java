package com.adissongomes.hexagonal.services.usecases;

import com.adissongomes.hexagonal.dto.Ticket;
import com.adissongomes.hexagonal.dto.TicketCreation;

public interface CreateTicket {
    /**
     * Create a ticket based on {@link TicketCreation} data.
     *
     * The {@link TicketCreation} should have a name information
     * to permit that a new number ticket to be created.
     *
     * @param ticketCreation creation request for a number ticket
     *
     * @return created ticket with it number and creation date
     *
     * @throws IllegalArgumentException when {@link TicketCreation} is null
     * or {@link TicketCreation#getName()} is empty
     */
    Ticket create(TicketCreation ticketCreation);
}
