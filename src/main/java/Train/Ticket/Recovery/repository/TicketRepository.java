package Train.Ticket.Recovery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Train.Ticket.Recovery.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {

    Ticket findByPnr(String pnr);

    boolean existsByPnr(String pnr);
}