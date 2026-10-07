package Train.Ticket.Recovery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Train.Ticket.Recovery.entity.District;

public interface DistrictRepository extends JpaRepository<District, Integer> {

    List<District> findByStateIdOrderByDistrictNameAsc(Integer stateId);
}