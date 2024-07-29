package az.ingress.turboapi.repository;

import az.ingress.turboapi.models.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
