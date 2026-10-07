package Train.Ticket.Recovery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Train.Ticket.Recovery.entity.State;
import Train.Ticket.Recovery.repository.StateRepository;

@RestController
public class StateController {

    private final StateRepository stateRepository;

    public StateController(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @GetMapping("/api/states")
    public List<State> getStates() {
        return stateRepository.findAllByOrderByStateNameAsc();
    }
}