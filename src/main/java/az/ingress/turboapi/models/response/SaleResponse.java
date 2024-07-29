package az.ingress.turboapi.models.response;

import az.ingress.turboapi.models.domain.City;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaleResponse {

    private Long id;

    private CarResponse carResponse;

    private UserResponse user;

    private City city;

    private boolean credit;

    private boolean barter;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
