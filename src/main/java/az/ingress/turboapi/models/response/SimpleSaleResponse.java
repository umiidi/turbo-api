package az.ingress.turboapi.models.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SimpleSaleResponse {

    private Long id;

    private String brand;

    private String model;

    private String city;

    private Long price;

    private Long mileage;

    private Integer year;

    private LocalDateTime createdAt;

}
