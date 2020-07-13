package com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.impl;

import com.testRestWebService.testrestfulwebservice.repositories.requestResponseRecordRepository.HomePageRequestResponseRecordRepository;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.HomePageRequestResponseRecordService;
import org.springframework.stereotype.Service;
import com.testRestWebService.testrestfulwebservice.domain.mapper.*;


import java.util.Optional;

@Service
public class HomePageRequestResponseRecordServiceImpl implements HomePageRequestResponseRecordService {

    private HomePageRequestResponseRecordRepository homePageRequestResponseRecordRepository;

    public HomePageRequestResponseRecordServiceImpl(HomePageRequestResponseRecordRepository homePageRequestResponseRecordRepository) {
        this.homePageRequestResponseRecordRepository = homePageRequestResponseRecordRepository;
    }

    public HomePageRequestResponseRecordRepository getHomePageRequestResponseRecordRepository() {
        return homePageRequestResponseRecordRepository;
    }

    public void setHomePageRequestResponseRecordRepository(HomePageRequestResponseRecordRepository homePageRequestResponseRecordRepository) {
        this.homePageRequestResponseRecordRepository = homePageRequestResponseRecordRepository;
    }

    @Override
    public Optional<HomePageRequestResponseRecord> findById(Long id) {
        return homePageRequestResponseRecordRepository.findById(id);
    }

    @Override
    public Iterable<HomePageRequestResponseRecord> getHomePages() {
        return homePageRequestResponseRecordRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        homePageRequestResponseRecordRepository.deleteById(id);
    }

    @Override
    public void save(HomePageRequestResponseRecord homePage) {
        homePageRequestResponseRecordRepository.save(homePage);
    }
}
