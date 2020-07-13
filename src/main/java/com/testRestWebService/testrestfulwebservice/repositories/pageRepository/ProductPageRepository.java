package com.testRestWebService.testrestfulwebservice.repositories.pageRepository;

import com.testRestWebService.testrestfulwebservice.domain.ProductPage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductPageRepository extends CrudRepository<ProductPage,Long> {
    Optional<ProductPage> findByWebURL(String webURL);

}
