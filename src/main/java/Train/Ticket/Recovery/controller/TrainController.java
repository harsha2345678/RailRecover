package Train.Ticket.Recovery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Train.Ticket.Recovery.entity.Train;
import Train.Ticket.Recovery.service.TrainService;

@RestController
public class TrainController {

    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/find-trains")
    public List<Train> findTrains(
            @RequestParam int sourceDistrictId,
            @RequestParam int destinationDistrictId) {

        return trainService.findTrains(
                sourceDistrictId,
                destinationDistrictId
        );
    }
}