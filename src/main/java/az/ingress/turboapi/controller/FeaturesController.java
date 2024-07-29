package az.ingress.turboapi.controller;

import az.ingress.turboapi.models.base.BaseResponse;
import az.ingress.turboapi.service.impl.FeaturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/features")
public class FeaturesController {

    private final FeaturesService featuresService;

    @GetMapping()
    public BaseResponse<?> get() {
        return BaseResponse.success(featuresService.get());
    }


}
