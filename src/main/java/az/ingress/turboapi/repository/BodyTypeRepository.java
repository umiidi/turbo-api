package az.ingress.turboapi.repository;

import az.ingress.turboapi.models.domain.BodyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyTypeRepository extends JpaRepository<BodyType, Long> {
}
