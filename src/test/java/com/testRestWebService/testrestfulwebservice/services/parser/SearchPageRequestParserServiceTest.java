package com.testRestWebService.testrestfulwebservice.services.parser;

import com.testRestWebService.testrestfulwebservice.domain.HomePage;
import com.testRestWebService.testrestfulwebservice.domain.SearchPage;
import com.testRestWebService.testrestfulwebservice.service.parserServices.HomePageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.SearchPageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.impl.HomePageRequestParserServiceImpl;
import com.testRestWebService.testrestfulwebservice.service.parserServices.impl.SearchPageResultParserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class SearchPageRequestParserServiceTest {

    SearchPageRequestParserService searchPageRequestParserService;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        searchPageRequestParserService=new SearchPageResultParserServiceImpl();
    }

    @Test
    public void getProductPage()throws Exception{

        SearchPage searchPage=searchPageRequestParserService.parseSearchRequest("https://www.trendyol.com/tum-urunler?q=elbise");
        assertEquals(searchPage.getQuery(),"elbise");
        assertEquals(searchPage.getWebURL(),"https://www.trendyol.com/tum-urunler?q=elbise");

    }
}
