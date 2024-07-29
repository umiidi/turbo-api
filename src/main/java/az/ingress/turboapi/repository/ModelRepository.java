package az.ingress.turboapi.repository;

import az.ingress.turboapi.models.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
