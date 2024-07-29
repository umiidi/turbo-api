package az.ingress.turboapi.controller;

import az.ingress.turboapi.models.base.BaseResponse;
import az.ingress.turboapi.models.enums.CustomSortBy;
import az.ingress.turboapi.models.spesification.SaleCriteria;
import az.ingress.turboapi.models.request.SaleRequest;
import az.ingress.turboapi.models.response.SimpleSaleResponse;
import az.ingress.turboapi.models.response.SaleResponse;
import az.ingress.turboapi.service.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sales")
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public BaseResponse<List<SimpleSaleResponse>> list(@RequestParam int page,
                                                       @RequestParam int size,
                                                       @RequestParam CustomSortBy sortBy,
                                                       @RequestBody SaleCriteria saleCriteria) {
        return BaseResponse.success(saleService.list(page, size, sortBy, saleCriteria));
    }

    @GetMapping("/{id}")
    public BaseResponse<SaleResponse> get(@PathVariable long id) {
        return BaseResponse.success(saleService.get(id));
    }

    @PostMapping
    public BaseResponse<SaleResponse> create(@Valid @RequestBody SaleRequest saleRequest) {
        return BaseResponse.success(saleService.createSale(saleRequest));
    }

    @PutMapping("/{id}")
    public BaseResponse<SaleResponse> update(@PathVariable long id, @Valid @RequestBody SaleRequest saleRequest) {
        return BaseResponse.success(saleService.update(id, saleRequest));
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Void> delete(@PathVariable long id) {
        saleService.delete(id);
        return BaseResponse.success();
    }

}
