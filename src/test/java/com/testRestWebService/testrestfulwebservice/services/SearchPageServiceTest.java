package com.testRestWebService.testrestfulwebservice.services;

import com.testRestWebService.testrestfulwebservice.domain.ProductPage;
import com.testRestWebService.testrestfulwebservice.domain.SearchPage;
import com.testRestWebService.testrestfulwebservice.repositories.pageRepository.ProductPageRepository;
import com.testRestWebService.testrestfulwebservice.repositories.pageRepository.SearchPageRepository;
import com.testRestWebService.testrestfulwebservice.service.dataServices.impl.ProductPageServiceImpl;
import com.testRestWebService.testrestfulwebservice.service.dataServices.impl.SearchPageServiceImpl;
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

public class SearchPageServiceTest {
    SearchPageServiceImpl searchPageService;
    @Mock
    SearchPageRepository searchPageRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        searchPageService = new SearchPageServiceImpl(searchPageRepository);
    }

    @Test
    public void getSearchPage()throws Exception{

        SearchPage searchPage = new SearchPage();
        List productsData = new ArrayList();
        productsData.add(searchPage);

        when(searchPageService.getHomePages()).thenReturn((List<SearchPage>) productsData);

        List<SearchPage> productPages= (List<SearchPage>) searchPageService.getHomePages();
        assertEquals(productPages.size(),1);
        verify(searchPageRepository,times(1)).findAll();
    }

}
