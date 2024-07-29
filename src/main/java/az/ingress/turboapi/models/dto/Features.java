package az.ingress.turboapi.models.dto;

import az.ingress.turboapi.models.domain.BodyType;
import az.ingress.turboapi.models.domain.City;
import az.ingress.turboapi.models.domain.Color;
import az.ingress.turboapi.models.enums.GearBox;
import az.ingress.turboapi.models.enums.Transmission;
import az.ingress.turboapi.models.response.BrandResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Features {

    List<BrandResponse> brandList;
    List<BodyType> bodyTypeList;
    CarOptionsFeature carOptions;
    List<Color> colorList;
    List<City> cityList;
    List<GearBox> gearBoxList;
    List<Transmission> transmissionList;

}
