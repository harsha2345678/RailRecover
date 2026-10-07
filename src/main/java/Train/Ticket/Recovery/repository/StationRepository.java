package Train.Ticket.Recovery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Train.Ticket.Recovery.entity.Station;

public interface StationRepository extends JpaRepository<Station, Integer> {

    List<Station> findByDistrictIdOrderByStationNameAsc(Integer districtId);
}