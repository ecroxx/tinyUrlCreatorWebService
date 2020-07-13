package com.testRestWebService.testrestfulwebservice.services.parser;

import com.testRestWebService.testrestfulwebservice.domain.HomePage;
import com.testRestWebService.testrestfulwebservice.domain.ProductPage;
import com.testRestWebService.testrestfulwebservice.domain.SearchPage;
import com.testRestWebService.testrestfulwebservice.service.parserServices.HomePageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.ProductPageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.impl.HomePageRequestParserServiceImpl;
import com.testRestWebService.testrestfulwebservice.service.parserServices.impl.ProductPageRequestParserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class HomePageRequestParserServiceTest {


    HomePageRequestParserService homePageRequestParserService;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        homePageRequestParserService=new HomePageRequestParserServiceImpl();
    }

    @Test
    public void getProductPage()throws Exception{

        HomePage homePage=homePageRequestParserService.parseHomeRequest("https://www.trendyol.com/butik/liste/kadin");
        assertEquals(homePage.getSectionName(),"kadin");
        assertEquals(homePage.getWebURL(),"https://www.trendyol.com/butik/liste/kadin");

    }
}
