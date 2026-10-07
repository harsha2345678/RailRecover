package Train.Ticket.Recovery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Train.Ticket.Recovery.entity.Train;
import Train.Ticket.Recovery.repository.TrainRepository;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<Train> findTrains(
            int sourceDistrictId,
            int destinationDistrictId) {

        return trainRepository
                .findBySourceDistrictIdAndDestinationDistrictId(
                        sourceDistrictId,
                        destinationDistrictId
                );
    }
}