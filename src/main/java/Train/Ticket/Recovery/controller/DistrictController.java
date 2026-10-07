package Train.Ticket.Recovery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Train.Ticket.Recovery.entity.District;
import Train.Ticket.Recovery.repository.DistrictRepository;

@RestController
public class DistrictController {

    private final DistrictRepository districtRepository;

    public DistrictController(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @GetMapping("/api/districts/{stateId}")
    public List<District> getDistricts(@PathVariable Integer stateId) {
        return districtRepository.findByStateIdOrderByDistrictNameAsc(stateId);
    }
}