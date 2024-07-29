package az.ingress.turboapi.repository;

import az.ingress.turboapi.models.domain.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
