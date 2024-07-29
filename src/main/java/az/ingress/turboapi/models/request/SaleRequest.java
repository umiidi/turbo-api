package az.ingress.turboapi.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaleRequest {

    @NotNull
    private Long userId;

    @NotNull
    private CarRequest car;

    @NotNull
    private Long cityId;

    private boolean credit;
    private boolean barter;

    @NotBlank
    private String description;

}
