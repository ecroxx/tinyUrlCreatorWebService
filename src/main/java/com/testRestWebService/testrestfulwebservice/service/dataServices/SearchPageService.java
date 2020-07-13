package com.testRestWebService.testrestfulwebservice.service.dataServices;

import com.testRestWebService.testrestfulwebservice.domain.SearchPage;

import java.util.Optional;

public interface SearchPageService {
    Optional<SearchPage> findById(Long id);
    Iterable<SearchPage> getHomePages();
    void deleteById(Long id);
    void save(SearchPage homePage);
}
