package com.testRestWebService.testrestfulwebservice.service.parserServices;

import com.testRestWebService.testrestfulwebservice.domain.ProductPage;

public interface ProductPageRequestParserService {
    ProductPage parseProductRequest(String request);
}
