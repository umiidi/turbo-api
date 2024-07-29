package az.ingress.turboapi.models.spesification;

import az.ingress.turboapi.models.domain.Sale;
import az.ingress.turboapi.models.request.CarOptionsRequest;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SaleSpesification {


    // todo: optimize this method
    public static Specification<Sale> list(SaleCriteria saleCriteria) {
        return (root, query, criteriaBuilder) -> {
            root.fetch("city", JoinType.LEFT);
            root.fetch("car", JoinType.LEFT)
                    .fetch("model", JoinType.LEFT)
                    .fetch("brand", JoinType.LEFT);

            List<Predicate> list = new ArrayList<>();

            if (saleCriteria.getModelIdList() != null && !saleCriteria.getModelIdList().isEmpty()) {
                list.add(criteriaBuilder.or(root.get("car").get("model").get("id").in(saleCriteria.getModelIdList())));
            } else if (saleCriteria.getBrandId() != null) {
                list.add(criteriaBuilder.equal(root.get("car").get("model").get("brand").get("id"), (saleCriteria.getBrandId())));
            }

            if (saleCriteria.getIsNew() != null) {
                list.add(criteriaBuilder.equal(root.get("car").get("isNew"), (saleCriteria.getIsNew())));
            }

            if (saleCriteria.getCityIdList() != null && !saleCriteria.getCityIdList().isEmpty()) {
                list.add(criteriaBuilder.or(root.get("city").get("id").in(saleCriteria.getCityIdList())));
            }

            if (saleCriteria.getMinPrice() != null) {
                list.add(criteriaBuilder.greaterThanOrEqualTo(root.get("car").get("price"), saleCriteria.getMinPrice()));
            }
            if (saleCriteria.getMaxPrice() != null) {
                list.add(criteriaBuilder.lessThanOrEqualTo(root.get("car").get("price"), saleCriteria.getMaxPrice()));
            }

            if (saleCriteria.getCredit() != null) {
                list.add(criteriaBuilder.equal(root.get("credit"), (saleCriteria.getCredit())));
            }

            if (saleCriteria.getBarter() != null) {
                list.add(criteriaBuilder.equal(root.get("barter"), (saleCriteria.getBarter())));
            }

            if (saleCriteria.getMinYear() != null) {
                list.add(criteriaBuilder.greaterThanOrEqualTo(root.get("car").get("year"), saleCriteria.getMinYear()));
            }
            if (saleCriteria.getMaxYear() != null) {
                list.add(criteriaBuilder.lessThanOrEqualTo(root.get("car").get("year"), saleCriteria.getMaxYear()));
            }

            if (saleCriteria.getColorIdList() != null && !saleCriteria.getColorIdList().isEmpty()) {
                list.add(criteriaBuilder.or(root.get("car").get("color").get("id").in(saleCriteria.getColorIdList())));
            }

            if (saleCriteria.getGearBoxList() != null && !saleCriteria.getGearBoxList().isEmpty()) {
                list.add(criteriaBuilder.or(root.get("car").get("gearBox").in(saleCriteria.getGearBoxList())));
            }

            if (saleCriteria.getTransmissionList() != null && !saleCriteria.getTransmissionList().isEmpty()) {
                list.add(criteriaBuilder.or(root.get("car").get("transmission").in(saleCriteria.getTransmissionList())));
            }

            //todo: optimize block
            if (saleCriteria.getCarOptions() != null) {
                CarOptionsRequest options = saleCriteria.getCarOptions();
                final Path<?> carOptionsRoot = root.get("car").get("carOptions");
                list.add(criteriaBuilder.and(
                        criteriaBuilder.equal(carOptionsRoot.get("alloyWheels"), options.isAlloyWheels()),
                        criteriaBuilder.equal(carOptionsRoot.get("centralClosure"), options.isCentralClosure()),
                        criteriaBuilder.equal(carOptionsRoot.get("leatherSalon"), options.isLeatherSalon()),
                        criteriaBuilder.equal(carOptionsRoot.get("seatVentilation"), options.isSeatVentilation()),
                        criteriaBuilder.equal(carOptionsRoot.get("abs"), options.isAbs()),
                        criteriaBuilder.equal(carOptionsRoot.get("parkingRadar"), options.isParkingRadar()),
                        criteriaBuilder.equal(carOptionsRoot.get("xenonLamps"), options.isXenonLamps()),
                        criteriaBuilder.equal(carOptionsRoot.get("luke"), options.isLuke()),
                        criteriaBuilder.equal(carOptionsRoot.get("conditioners"), options.isConditioners()),
                        criteriaBuilder.equal(carOptionsRoot.get("rearViewCamera"), options.isRearViewCamera()),
                        criteriaBuilder.equal(carOptionsRoot.get("rainSensor"), options.isRainSensor()),
                        criteriaBuilder.equal(carOptionsRoot.get("seatHeating"), options.isSeatHeating()),
                        criteriaBuilder.equal(carOptionsRoot.get("sideCurtains"), options.isSideCurtains())
                ));
            }

            return criteriaBuilder.and(list.toArray(Predicate[]::new));
        };
    }

}
