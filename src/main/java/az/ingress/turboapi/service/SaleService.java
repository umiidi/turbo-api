package az.ingress.turboapi.service;

import az.ingress.turboapi.models.enums.CustomSortBy;
import az.ingress.turboapi.models.spesification.SaleCriteria;
import az.ingress.turboapi.models.request.SaleRequest;
import az.ingress.turboapi.models.response.SaleResponse;
import az.ingress.turboapi.models.response.SimpleSaleResponse;

import java.util.List;

public interface SaleService {

    List<SimpleSaleResponse> list(int page, int size, CustomSortBy sortBy, SaleCriteria saleCriteria);

    SaleResponse get(long id);

    SaleResponse createSale(SaleRequest saleRequest);

    SaleResponse update(long id, SaleRequest saleRequest);

    void delete(long id);

}
