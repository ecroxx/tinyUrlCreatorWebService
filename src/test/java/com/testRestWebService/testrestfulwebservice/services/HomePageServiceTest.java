package com.testRestWebService.testrestfulwebservice.services;

import com.testRestWebService.testrestfulwebservice.domain.HomePage;
import com.testRestWebService.testrestfulwebservice.domain.ProductPage;
import com.testRestWebService.testrestfulwebservice.repositories.pageRepository.HomePageRepository;
import com.testRestWebService.testrestfulwebservice.repositories.pageRepository.ProductPageRepository;
import com.testRestWebService.testrestfulwebservice.service.dataServices.impl.HomePageServiceImpl;
import com.testRestWebService.testrestfulwebservice.service.dataServices.impl.ProductPageServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HomePageServiceTest {

    HomePageServiceImpl homePageService;
    @Mock
    HomePageRepository homePageRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        homePageService = new HomePageServiceImpl(homePageRepository);
    }

    @Test
    public void getProductPage()throws Exception{

        HomePage homePage = new HomePage();
        List homesData = new ArrayList();
        homesData.add(homePage);

        when(homePageService.getHomePages()).thenReturn((List<HomePage>) homesData);

        List<HomePage> homePages= (List<HomePage>) homePageService.getHomePages();
        assertEquals(homePages.size(),1);
        verify(homePageRepository,times(1)).findAll();
    }


}
