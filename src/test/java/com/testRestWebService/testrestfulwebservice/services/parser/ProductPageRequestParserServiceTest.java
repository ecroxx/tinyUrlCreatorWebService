package com.testRestWebService.testrestfulwebservice.services.parser;

import com.testRestWebService.testrestfulwebservice.domain.HomePage;
import com.testRestWebService.testrestfulwebservice.domain.ProductPage;
import com.testRestWebService.testrestfulwebservice.repositories.pageRepository.HomePageRepository;
import com.testRestWebService.testrestfulwebservice.service.dataServices.impl.HomePageServiceImpl;
import com.testRestWebService.testrestfulwebservice.service.parserServices.ProductPageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.impl.ProductPageRequestParserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductPageRequestParserServiceTest {


    ProductPageRequestParserService productPageRequestParserService;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        productPageRequestParserService=new ProductPageRequestParserServiceImpl();
    }

    @Test
    public void getProductPage()throws Exception{

        ProductPage productPage=productPageRequestParserService.parseProductRequest("https://www.trendyol.com/avva/erkek-beyaz-polo-yaka-duz-t-shirt-a01b1175-p-42427628?boutiqueId=512009&merchantId=107671");
        assertEquals(productPage.getContentID(),Integer.valueOf(42427628));
        assertEquals(productPage.getMercantID(),Integer.valueOf(107671));
        assertEquals(productPage.getButiqueID(),Integer.valueOf(512009));
        assertEquals(productPage.getBrandName(),"avva");
        assertEquals(productPage.getProductName(),"erkek-beyaz-polo-yaka-duz-t-shirt-a01b1175");
        assertEquals(productPage.getWebURL(),"https://www.trendyol.com/avva/erkek-beyaz-polo-yaka-duz-t-shirt-a01b1175-p-42427628?boutiqueId=512009&merchantId=107671");
        assertEquals(productPage.getDomain(),"https://www.trendyol.com/");

    }

}
