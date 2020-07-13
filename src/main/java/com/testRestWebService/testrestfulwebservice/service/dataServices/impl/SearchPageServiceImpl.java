package com.testRestWebService.testrestfulwebservice.service.dataServices.impl;

import com.testRestWebService.testrestfulwebservice.domain.SearchPage;
import com.testRestWebService.testrestfulwebservice.repositories.pageRepository.SearchPageRepository;
import com.testRestWebService.testrestfulwebservice.service.dataServices.SearchPageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchPageServiceImpl implements SearchPageService {


    private final SearchPageRepository searchPageRepository;

    public SearchPageServiceImpl(SearchPageRepository searchPageRepository) {
        this.searchPageRepository = searchPageRepository;
    }

    @Override
    public Optional<SearchPage> findById(Long id) {
        return searchPageRepository.findById(id);
    }

    @Override
    public List<SearchPage> getHomePages() {
        return (List<SearchPage>)searchPageRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        searchPageRepository.deleteById(id);
    }

    @Override
    public void save(SearchPage searchPage) {
        if(!searchPageRepository.findByQuery(searchPage.getQuery()).isPresent()) {
            searchPageRepository.save(searchPage);
        }
    }
}
