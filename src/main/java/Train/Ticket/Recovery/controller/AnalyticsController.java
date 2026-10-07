package Train.Ticket.Recovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Train.Ticket.Recovery.repository.TicketRepository;

@RestController
public class AnalyticsController {

    private final TicketRepository ticketRepository;

    public AnalyticsController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/api/analytics")
    public String analytics() {

        long totalTickets = ticketRepository.count();

        return "Total Tickets: " + totalTickets;
    }
}