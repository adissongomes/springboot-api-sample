package com.adissongomes.hexagonal.services.usecases;

import com.adissongomes.hexagonal.dto.Ticket;

public interface CallTicket {
    Ticket call(int number);
}
