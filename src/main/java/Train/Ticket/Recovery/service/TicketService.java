package Train.Ticket.Recovery.service;

import org.springframework.stereotype.Service;

import Train.Ticket.Recovery.entity.Ticket;
import Train.Ticket.Recovery.repository.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket getTicketByPnr(String pnr) {
        return ticketRepository.findByPnr(pnr);
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Duplicate Ticket Detection
    public boolean isDuplicateTicket(String pnr) {
        return ticketRepository.existsByPnr(pnr);
    }

    // Suspicious Recovery Detection
    public Ticket recoverTicket(String pnr) {

        Ticket ticket = ticketRepository.findByPnr(pnr);

        if (ticket == null) {
            return null;
        }

        int attempts = ticket.getRecoveryAttempts();

        attempts++;

        ticket.setRecoveryAttempts(attempts);

        if (attempts >= 3) {
            ticket.setRecoveryStatus("SUSPICIOUS");
        } else {
            ticket.setRecoveryStatus("REQUESTED");
        }

        return ticketRepository.save(ticket);
    }
}