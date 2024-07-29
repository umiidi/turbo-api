package az.ingress.turboapi.models.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BrandResponse {

    private Long id;
    private String name;
    private List<ModelResponse> models;

}
