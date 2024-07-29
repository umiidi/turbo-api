package az.ingress.turboapi.repository;

import az.ingress.turboapi.models.domain.Brand;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    @EntityGraph(attributePaths = {"models"})
    List<Brand> findAll();

}
