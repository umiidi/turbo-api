package az.ingress.turboapi.models.spesification;

import az.ingress.turboapi.models.enums.GearBox;
import az.ingress.turboapi.models.enums.Transmission;
import az.ingress.turboapi.models.request.CarOptionsRequest;
import lombok.Data;

import java.util.List;

@Data
public class SaleCriteria {
    
    private Long brandId;
    private List<Long> modelIdList;

    private Boolean isNew;
    private List<Long> cityIdList;

    private Long minPrice;
    private Long maxPrice;

    private Boolean credit;
    private Boolean barter;

    private List<Long> bodyTypeList;

    private Integer minYear;
    private Integer maxYear;

    private List<Long> colorIdList;

    private List<GearBox> gearBoxList;
    private List<Transmission> transmissionList;

    private CarOptionsRequest carOptions;

}
