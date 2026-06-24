package fr.eni.ludo.repository;

import fr.eni.ludo.bo.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
