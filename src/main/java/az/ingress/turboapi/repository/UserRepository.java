package az.ingress.turboapi.repository;

import az.ingress.turboapi.models.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
