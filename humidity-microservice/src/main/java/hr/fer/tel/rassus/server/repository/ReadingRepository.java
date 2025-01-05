package hr.fer.tel.rassus.server.repository;

import hr.fer.tel.rassus.server.beans.ReadingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends JpaRepository<ReadingDTO, Long> {
  //  TODO
}
