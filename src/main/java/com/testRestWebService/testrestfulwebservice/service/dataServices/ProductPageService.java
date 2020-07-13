package com.testRestWebService.testrestfulwebservice.service.dataServices;

import com.testRestWebService.testrestfulwebservice.domain.ProductPage;

import java.util.Optional;

public interface ProductPageService {

    Optional<ProductPage> findById(Long id);
    Iterable<ProductPage> getHomePages();
    void deleteById(Long id);
    void save(ProductPage productPage);
}
