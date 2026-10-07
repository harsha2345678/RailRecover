package Train.Ticket.Recovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Train.Ticket.Recovery.entity.Ticket;
import Train.Ticket.Recovery.service.TicketService;

@RestController
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/check-ticket")
    public Ticket checkTicket(@RequestParam String pnr) {
        return ticketService.getTicketByPnr(pnr);
    }

    @GetMapping("/recover-ticket")
    public Ticket recoverTicket(@RequestParam String pnr) {
        return ticketService.recoverTicket(pnr);
    }

    // Duplicate Ticket Detection
    @GetMapping("/check-duplicate")
    public String checkDuplicate(@RequestParam String pnr) {

        if (ticketService.isDuplicateTicket(pnr)) {
            return "DUPLICATE";
        }

        return "NOT_DUPLICATE";
    }
}