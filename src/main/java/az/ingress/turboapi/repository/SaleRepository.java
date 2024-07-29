package az.ingress.turboapi.repository;

import az.ingress.turboapi.models.domain.Sale;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long>, JpaSpecificationExecutor<Sale> {

    @Query("SELECT s FROM Sale s " +
            "JOIN FETCH s.user " +
            "JOIN FETCH s.city " +
            "JOIN FETCH s.car c " +
            "JOIN FETCH c.color " +
            "JOIN FETCH c.carOptions " +
            "JOIN FETCH c.typeOfBody " +
            "JOIN FETCH c.model m " +
            "JOIN FETCH m.brand b " +
            "WHERE s.id = :id")
    Optional<Sale> findById(@Nullable Long id);

}
