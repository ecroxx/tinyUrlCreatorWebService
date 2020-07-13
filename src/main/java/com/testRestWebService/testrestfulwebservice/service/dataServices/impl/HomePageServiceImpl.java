package com.testRestWebService.testrestfulwebservice.service.dataServices.impl;

import com.testRestWebService.testrestfulwebservice.domain.HomePage;
import com.testRestWebService.testrestfulwebservice.repositories.pageRepository.HomePageRepository;
import com.testRestWebService.testrestfulwebservice.service.dataServices.HomePageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomePageServiceImpl implements HomePageService {


    private final HomePageRepository homePageRepository;

    public HomePageServiceImpl(HomePageRepository homePageRepository) {
        this.homePageRepository = homePageRepository;
    }

    @Override
    public Optional<HomePage> findById(Long id) {
        return homePageRepository.findById(id);
    }

    @Override
    public List<HomePage> getHomePages() {
        return (List<HomePage>) homePageRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
         homePageRepository.deleteById(id);
    }

    @Override
    public void save(HomePage homePage) {
        if(!homePageRepository.findBySectionName(homePage.getSectionName()).isPresent()){
            homePageRepository.save(homePage);
        }

    }
}
