package az.ingress.turboapi.repository;

import az.ingress.turboapi.models.domain.CarOptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOptionsRepository extends JpaRepository<CarOptions, Long> {
}
