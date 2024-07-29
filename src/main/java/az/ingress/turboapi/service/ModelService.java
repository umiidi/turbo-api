package az.ingress.turboapi.service;

import az.ingress.turboapi.models.domain.Model;
import az.ingress.turboapi.models.enums.CustomSortBy;
import az.ingress.turboapi.models.spesification.SaleCriteria;
import az.ingress.turboapi.models.request.SaleRequest;

import java.util.List;

public interface ModelService {

    List<Model> list(int page, int size, CustomSortBy sortBy, SaleCriteria saleCriteria);

    Model get(long id);

    Model createSale(SaleRequest saleRequest);

    Model update(long id, Model model);

    void delete(long id);




}
