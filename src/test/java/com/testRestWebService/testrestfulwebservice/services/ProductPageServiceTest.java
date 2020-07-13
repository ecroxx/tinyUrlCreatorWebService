package com.testRestWebService.testrestfulwebservice.services;

import com.testRestWebService.testrestfulwebservice.domain.ProductPage;
import com.testRestWebService.testrestfulwebservice.repositories.pageRepository.ProductPageRepository;
import com.testRestWebService.testrestfulwebservice.service.dataServices.impl.ProductPageServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ProductPageServiceTest {

    ProductPageServiceImpl productPageService;
    @Mock
    ProductPageRepository productPageRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        productPageService = new ProductPageServiceImpl(productPageRepository);
    }

    @Test
    public void getProductPage()throws Exception{

        ProductPage productPage = new ProductPage();
        List productsData = new ArrayList();
        productsData.add(productPage);

        when(productPageService.getHomePages()).thenReturn((List<ProductPage>) productsData);

        List<ProductPage> productPages= (List<ProductPage>) productPageService.getHomePages();
        assertEquals(productPages.size(),1);
        verify(productPageRepository,times(1)).findAll();
    }

}
