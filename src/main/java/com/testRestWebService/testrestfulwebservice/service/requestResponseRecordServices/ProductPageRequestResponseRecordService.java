package com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices;
import com.testRestWebService.testrestfulwebservice.domain.mapper.*;

import java.util.Optional;

public interface ProductPageRequestResponseRecordService {
    Optional<ProductPageRequestResponseRecord> findById(Long id);
    Iterable<ProductPageRequestResponseRecord> getHomePages();
    void deleteById(Long id);
    void save(ProductPageRequestResponseRecord productPageRequestResponseRecord);
}
