package com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.impl;

import com.testRestWebService.testrestfulwebservice.repositories.requestResponseRecordRepository.ProductPageRequestResponseRecordRepository;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.ProductPageRequestResponseRecordService;
import org.springframework.stereotype.Service;
import com.testRestWebService.testrestfulwebservice.domain.mapper.*;


import java.util.Optional;

@Service
public class ProductPageRequestResponseRecordServiceImpl implements ProductPageRequestResponseRecordService {

    private ProductPageRequestResponseRecordRepository productPageRequestResponseRecordRepository;

    public ProductPageRequestResponseRecordServiceImpl(ProductPageRequestResponseRecordRepository productPageRequestResponseRecordRepository) {
        this.productPageRequestResponseRecordRepository = productPageRequestResponseRecordRepository;
    }

    public ProductPageRequestResponseRecordRepository getProductPageRequestResponseRecordRepository() {
        return productPageRequestResponseRecordRepository;
    }

    public void setProductPageRequestResponseRecordRepository(ProductPageRequestResponseRecordRepository productPageRequestResponseRecordRepository) {
        this.productPageRequestResponseRecordRepository = productPageRequestResponseRecordRepository;
    }

    @Override
    public Optional<ProductPageRequestResponseRecord> findById(Long id) {

        return productPageRequestResponseRecordRepository.findById(id);
    }

    @Override
    public Iterable<ProductPageRequestResponseRecord> getHomePages() {

        return productPageRequestResponseRecordRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        productPageRequestResponseRecordRepository.deleteById(id);
    }

    @Override
    public void save(ProductPageRequestResponseRecord homePage) {
       productPageRequestResponseRecordRepository.save(homePage);
    }
}
