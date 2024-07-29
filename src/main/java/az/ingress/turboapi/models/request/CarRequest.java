package az.ingress.turboapi.models.request;

import az.ingress.turboapi.models.enums.Currency;
import az.ingress.turboapi.models.enums.GearBox;
import az.ingress.turboapi.models.enums.Transmission;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CarRequest {

    @NotNull
    private Long modelId;

    @NotNull
    private Long typeOfBodyId;

    @NotNull
    private Long colorId;

    @Positive
    @Min(1900)
    @Max(2100)
    private Integer year;

    @Positive
    private Long mileage;

    private boolean isNew;

    @Positive
    private Long price;

    private Currency currency;
    private GearBox gearBox;
    private Transmission transmission;

    @NotNull
    private CarOptionsRequest carOptions;

}
