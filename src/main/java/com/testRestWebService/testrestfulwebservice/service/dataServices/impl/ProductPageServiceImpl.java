package com.testRestWebService.testrestfulwebservice.service.dataServices.impl;

import com.testRestWebService.testrestfulwebservice.domain.ProductPage;
import com.testRestWebService.testrestfulwebservice.repositories.pageRepository.ProductPageRepository;
import com.testRestWebService.testrestfulwebservice.service.dataServices.ProductPageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPageServiceImpl implements ProductPageService {

    private final ProductPageRepository productPageRepository;

    public ProductPageServiceImpl(ProductPageRepository productPageRepository) {
        this.productPageRepository = productPageRepository;
    }

    @Override
    public Optional<ProductPage> findById(Long id) {
        return productPageRepository.findById(id);
    }

    @Override
    public List<ProductPage> getHomePages() {
        return (List<ProductPage>) productPageRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        productPageRepository.deleteById(id);
    }

    @Override
    public void save(ProductPage productPage) {
        if(!productPageRepository.findByWebURL(productPage.getWebURL()).isPresent()) {
            productPageRepository.save(productPage);
        }
    }
}
