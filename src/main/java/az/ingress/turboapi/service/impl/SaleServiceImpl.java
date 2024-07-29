package az.ingress.turboapi.service.impl;

import az.ingress.turboapi.exception.types.NotFoundException;
import az.ingress.turboapi.models.domain.*;
import az.ingress.turboapi.models.enums.CustomSortBy;
import az.ingress.turboapi.models.spesification.SaleCriteria;
import az.ingress.turboapi.models.request.CarOptionsRequest;
import az.ingress.turboapi.models.request.CarRequest;
import az.ingress.turboapi.models.request.SaleRequest;
import az.ingress.turboapi.models.response.*;
import az.ingress.turboapi.models.spesification.SaleSpesification;
import az.ingress.turboapi.repository.*;
import az.ingress.turboapi.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final ModelMapper modelMapper;
    private final SaleRepository saleRepository;
    private final CityRepository cityRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final BodyTypeRepository bodyTypeRepository;
    private final ColorRepository colorRepository;

    @Override
    public List<SimpleSaleResponse> list(int page, int size, CustomSortBy sortBy, SaleCriteria saleCriteria) {
        System.out.println(saleCriteria);
        Page<Sale> sales = saleRepository.findAll(
                SaleSpesification.list(saleCriteria),
                PageRequest.of(page, size, Sort.by(sortBy.getOrder())));

        return sales.stream().map(
                (sale) -> SimpleSaleResponse.builder()
                        .id(sale.getId())
                        .brand(sale.getCar().getModel().getBrand().getName())
                        .model(sale.getCar().getModel().getName())
                        .city(sale.getCity().getName())
                        .price(sale.getCar().getPrice())
                        .mileage(sale.getCar().getMileage())
                        .year(sale.getCar().getYear())
                        .createdAt(sale.getCreatedAt())
                        .build()
        ).toList();
    }

    @Override
    public SaleResponse get(long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("sale not found with id: " + id));
        return getSaleResponse(sale);
    }

    @Override
    @Transactional
    public SaleResponse createSale(SaleRequest saleRequest) {
        Sale sale = getSale(saleRequest);
        sale.setCreatedAt(LocalDateTime.now());
        saleRepository.save(sale);
        return getSaleResponse(sale);
    }

    @Override
    public SaleResponse update(long id, SaleRequest saleRequest) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("sale not found with id: %d", id)));
        Sale saleNew = getSale(saleRequest);
        saleNew.setId(id);
        saleNew.setCreatedAt(sale.getCreatedAt());
        saleNew.setUpdatedAt(LocalDateTime.now());
        saleNew.getCar().setId(sale.getCar().getId());     // yeni car yaratmaması üçün
        saleNew.getCar().getCarOptions().setId(sale.getCar().getCarOptions().getId());

        saleRepository.save(saleNew);
        return getSaleResponse(saleNew);
    }

    @Override
    public void delete(long id) {
        saleRepository.deleteById(id);
    }

    private Sale getSale(SaleRequest saleRequest) {
        User user = userRepository.findById(saleRequest.getUserId())
                .orElseThrow(() -> new NotFoundException(String.format("user not found with id: %d", saleRequest.getUserId())));
        City city = cityRepository.findById(saleRequest.getCityId())
                .orElseThrow(() -> new NotFoundException(String.format("city not found with id: %d", saleRequest.getCityId())));
        CarRequest carRequest = saleRequest.getCar();

        Model model = modelRepository.findById(carRequest.getModelId())
                .orElseThrow(() -> new NotFoundException(String.format("model not found with id: %d", carRequest.getModelId())));
        BodyType bodyType = bodyTypeRepository.findById(carRequest.getTypeOfBodyId())
                .orElseThrow(() -> new NotFoundException(String.format("body type not found with id: %d", carRequest.getTypeOfBodyId())));
        Color color = colorRepository.findById(carRequest.getColorId())
                .orElseThrow(() -> new NotFoundException(String.format("color not found with id: %d", carRequest.getColorId())));

        CarOptionsRequest carOptionsRequest = carRequest.getCarOptions();
        CarOptions carOptions = modelMapper.map(carOptionsRequest, CarOptions.class);

        Car car = modelMapper.map(carRequest, Car.class);
        car.setModel(model);
        car.setTypeOfBody(bodyType);
        car.setColor(color);
        car.setCarOptions(carOptions);

        Sale sale = modelMapper.map(saleRequest, Sale.class);
        sale.setCar(car);
        sale.setUser(user);
        sale.setCity(city);
        return sale;
    }

    private SaleResponse getSaleResponse(Sale sale) {
        User user = sale.getUser();
        Car car = sale.getCar();
        CarResponse carResponse = modelMapper.map(car, CarResponse.class);
        Brand brand = car.getModel().getBrand();
        carResponse.setBrand(BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build());
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        SaleResponse saleResponse = modelMapper.map(sale, SaleResponse.class);
        saleResponse.setCarResponse(carResponse);
        saleResponse.setUser(userResponse);
        return saleResponse;
    }

}
