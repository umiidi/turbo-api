package az.ingress.turboapi.models.enums;

import org.springframework.data.domain.Sort;

public enum CustomSortBy {

    FIRST_CHEAP(Sort.Order.asc("Car.price")),
    FIRST_EXPENSIVE(Sort.Order.desc("Car.price")),
    BY_MILEAGE(Sort.Order.asc("Car.mileage")),
    BY_YEAR(Sort.Order.desc("Car.year")),
    BY_DATE(Sort.Order.desc("createdAt"));

    private final Sort.Order order;

    CustomSortBy(Sort.Order order) {
        this.order = order;
    }

    public Sort.Order getOrder() {
        return this.order;
    }

}
