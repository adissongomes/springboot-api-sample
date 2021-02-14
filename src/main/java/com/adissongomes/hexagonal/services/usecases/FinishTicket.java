package com.adissongomes.hexagonal.services.usecases;

import com.adissongomes.hexagonal.dto.Ticket;

public interface FinishTicket {
    Ticket finish(int number);
}
