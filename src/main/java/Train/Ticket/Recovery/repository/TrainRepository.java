package Train.Ticket.Recovery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Train.Ticket.Recovery.entity.Train;

public interface TrainRepository extends JpaRepository<Train, String> {

    List<Train> findBySourceDistrictIdAndDestinationDistrictId(
            int sourceDistrictId,
            int destinationDistrictId
    );
}