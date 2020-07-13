package com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.impl;

import com.testRestWebService.testrestfulwebservice.repositories.requestResponseRecordRepository.SearchPageRequestResponseRecordRepository;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.SearchPageRequestResponseRecordService;
import org.springframework.stereotype.Service;
import com.testRestWebService.testrestfulwebservice.domain.mapper.*;


import java.util.Optional;

@Service
public class SearchPageRequestResponseRecordServiceImpl implements SearchPageRequestResponseRecordService {

    private SearchPageRequestResponseRecordRepository searchPageRequestResponseRecordRepository;

    public SearchPageRequestResponseRecordServiceImpl(SearchPageRequestResponseRecordRepository searchPageRequestResponseRecordRepository) {
        this.searchPageRequestResponseRecordRepository = searchPageRequestResponseRecordRepository;
    }

    public SearchPageRequestResponseRecordRepository getSearchPageRequestResponseRecordRepository() {
        return searchPageRequestResponseRecordRepository;
    }

    public void setSearchPageRequestResponseRecordRepository(SearchPageRequestResponseRecordRepository searchPageRequestResponseRecordRepository) {
        this.searchPageRequestResponseRecordRepository = searchPageRequestResponseRecordRepository;
    }

    @Override
    public Optional<SearchPageRequestResponseRecord> findById(Long id) {
        return searchPageRequestResponseRecordRepository.findById(id);
    }

    @Override
    public Iterable<SearchPageRequestResponseRecord> getHomePages() {
        return searchPageRequestResponseRecordRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
      searchPageRequestResponseRecordRepository.deleteById(id);
    }

    @Override
    public void save(SearchPageRequestResponseRecord searchPageRequestResponseRecord) {
        searchPageRequestResponseRecordRepository.save(searchPageRequestResponseRecord);
    }
}
