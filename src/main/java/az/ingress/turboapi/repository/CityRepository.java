package az.ingress.turboapi.repository;

import az.ingress.turboapi.models.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
