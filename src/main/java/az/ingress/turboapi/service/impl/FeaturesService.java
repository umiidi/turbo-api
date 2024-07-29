package az.ingress.turboapi.service.impl;

import az.ingress.turboapi.models.dto.CarOptionsFeature;
import az.ingress.turboapi.models.dto.Features;
import az.ingress.turboapi.models.enums.GearBox;
import az.ingress.turboapi.models.enums.Transmission;
import az.ingress.turboapi.models.response.BrandResponse;
import az.ingress.turboapi.models.response.ModelResponse;
import az.ingress.turboapi.repository.BodyTypeRepository;
import az.ingress.turboapi.repository.BrandRepository;
import az.ingress.turboapi.repository.CityRepository;
import az.ingress.turboapi.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeaturesService {

    private final BrandRepository brandRepository;
    private final BodyTypeRepository bodyTypeRepository;
    private final CityRepository cityRepository;
    private final ColorRepository colorRepository;

    public Features get(){
        List<BrandResponse> brands = brandRepository.findAll().stream()
                .map((brand) -> BrandResponse.builder()
                        .id(brand.getId())
                        .name(brand.getName())
                        .models(brand.getModels().stream()
                                .map((model) -> new ModelResponse(model.getId(), model.getName())).toList())
                        .build()).toList();
        return Features.builder()
                .brandList(brands)
                .bodyTypeList(bodyTypeRepository.findAll())
                .carOptions(new CarOptionsFeature())
                .cityList(cityRepository.findAll())
                .colorList(colorRepository.findAll())
                .gearBoxList(List.of(GearBox.values()))
                .transmissionList(List.of(Transmission.values()))
                .build();
    }

}
