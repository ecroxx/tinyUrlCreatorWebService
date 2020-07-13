package com.testRestWebService.testrestfulwebservice.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.testRestWebService.testrestfulwebservice.domain.HomePage;
import com.testRestWebService.testrestfulwebservice.service.conversionServices.HomeConvertorService;
import com.testRestWebService.testrestfulwebservice.service.conversionServices.ProductConvertorService;
import com.testRestWebService.testrestfulwebservice.service.conversionServices.SearchConvertorService;
import com.testRestWebService.testrestfulwebservice.service.conversionServices.impl.HomeConvertorServiceImpl;
import com.testRestWebService.testrestfulwebservice.service.dataServices.HomePageService;
import com.testRestWebService.testrestfulwebservice.service.dataServices.ProductPageService;
import com.testRestWebService.testrestfulwebservice.service.dataServices.SearchPageService;
import com.testRestWebService.testrestfulwebservice.service.dataServices.impl.HomePageServiceImpl;
import com.testRestWebService.testrestfulwebservice.service.parserServices.HomePageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.ProductPageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.SearchPageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.impl.HomePageRequestParserServiceImpl;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.HomePageRequestResponseRecordService;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.OtherPageRequestResponseRecordService;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.ProductPageRequestResponseRecordService;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.SearchPageRequestResponseRecordService;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.impl.HomePageRequestResponseRecordServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WebServiceControllerTest {

    WebServiceController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new WebServiceController();

    }

    @Test
    public void testMockMVC() throws Exception {
       // public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
        String url ="http://localhost:8080";
        HomePage homePage = new HomePage();
        homePage.setId((long) 1000000);
        homePage.setSectionName("erkek");
        homePage.setWebURL("https://www.trendyol.com/butik/liste");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(homePage);


        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());

    }

}
