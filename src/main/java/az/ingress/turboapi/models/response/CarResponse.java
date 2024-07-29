package az.ingress.turboapi.models.response;

import az.ingress.turboapi.models.domain.BodyType;
import az.ingress.turboapi.models.domain.CarOptions;
import az.ingress.turboapi.models.domain.Color;
import az.ingress.turboapi.models.enums.Currency;
import az.ingress.turboapi.models.enums.GearBox;
import az.ingress.turboapi.models.enums.Transmission;
import lombok.Data;

@Data
public class CarResponse {

    private Long id;

    private ModelResponse model;

    private BrandResponse brand;

    private BodyType typeOfBody;

    private CarOptions carOptions;

    private Integer year;

    private Long price;
    private Currency currency;

    private Long mileage;

    private boolean isNew;

    private Color color;

    private GearBox gearBox;

    private Transmission transmission;

}
