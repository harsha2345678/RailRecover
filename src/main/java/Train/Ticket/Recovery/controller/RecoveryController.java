package Train.Ticket.Recovery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Train.Ticket.Recovery.entity.Train;
import Train.Ticket.Recovery.repository.TrainRepository;

@Controller
public class RecoveryController {

    private final TrainRepository trainRepository;

    public RecoveryController(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @GetMapping("/recovery")
    public String recoveryPage() {
        return "redirect:/recovery.html";
    }

    @GetMapping("/api/recovery")
    @ResponseBody
    public List<Train> findAlternativeTrains(
            @RequestParam int sourceDistrictId,
            @RequestParam int destinationDistrictId,
            @RequestParam String missedTime) {

        List<Train> trains =
                trainRepository.findBySourceDistrictIdAndDestinationDistrictId(
                        sourceDistrictId,
                        destinationDistrictId
                );

        return trains.stream()
                .filter(train ->
                        train.getDepartureTime()
                                .compareTo(missedTime) > 0
                )
                .sorted((a, b) ->
                        a.getDepartureTime()
                                .compareTo(b.getDepartureTime())
                )
                .toList();
    }
}