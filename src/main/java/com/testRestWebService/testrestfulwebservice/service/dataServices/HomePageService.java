package com.testRestWebService.testrestfulwebservice.service.dataServices;

import com.testRestWebService.testrestfulwebservice.domain.HomePage;

import java.util.Optional;

public interface HomePageService  {
    Optional<HomePage> findById(Long id);
    Iterable<HomePage> getHomePages();
    void deleteById(Long id);
    void save(HomePage homePage);
}
