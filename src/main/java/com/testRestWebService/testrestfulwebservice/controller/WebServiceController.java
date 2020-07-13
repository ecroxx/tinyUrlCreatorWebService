package com.testRestWebService.testrestfulwebservice.controller;

import com.testRestWebService.testrestfulwebservice.domain.*;
import com.testRestWebService.testrestfulwebservice.service.conversionServices.HomeConvertorService;
import com.testRestWebService.testrestfulwebservice.service.conversionServices.ProductConvertorService;
import com.testRestWebService.testrestfulwebservice.service.conversionServices.SearchConvertorService;
import com.testRestWebService.testrestfulwebservice.service.dataServices.HomePageService;
import com.testRestWebService.testrestfulwebservice.service.dataServices.ProductPageService;
import com.testRestWebService.testrestfulwebservice.service.dataServices.SearchPageService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.HomePageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.ProductPageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.parserServices.SearchPageRequestParserService;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.HomePageRequestResponseRecordService;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.OtherPageRequestResponseRecordService;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.ProductPageRequestResponseRecordService;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.SearchPageRequestResponseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.testRestWebService.testrestfulwebservice.domain.mapper.*;
import java.util.Date;
import java.sql.Timestamp;

@RestController
public class WebServiceController {


    @Autowired
    private ProductPageRequestParserService productPageRequestParserService;

    @Autowired
    private HomePageRequestParserService homePageRequestParserService;

    @Autowired
    private SearchPageRequestParserService searchPageResultParserService;

    @Autowired
    private HomePageService homePageService;

    @Autowired
    private ProductPageService productPageService;

    @Autowired
    private SearchPageService searchPageService;

    @Autowired
    private SearchPageRequestResponseRecordService searchPageRequestResponseRecordService;

    @Autowired
    private ProductPageRequestResponseRecordService productPageRequestResponseRecordService;

    @Autowired
    private HomePageRequestResponseRecordService homePageRequestResponseRecordService;

    @Autowired
    private OtherPageRequestResponseRecordService otherPageRequestResponseRecordService;

    @Autowired
    private ProductConvertorService productConvertorService;

    @Autowired
    private SearchConvertorService searchConvertorService;

    @Autowired
    private HomeConvertorService homeConvertorService;


    public WebServiceController() {
    }



    @RequestMapping(method=RequestMethod.POST, path = "")
    public WebUrlResultWrapper weblinkToDeeplinkConverter(@RequestBody WebUrlToDeepLink webUrlToDeepLink){
        if(webUrlToDeepLink.getWebURL().matches("(https://www.trendyol.com/butik/liste/)(cocuk|kadin|erkek|supermarket)")){
            return convertHomepageResult(webUrlToDeepLink);
        }else if(webUrlToDeepLink.getWebURL().matches("(https://www.trendyol.com/)(.*)(/)(.*)(-p-)(.*)")){
            return convertProductPageResult(webUrlToDeepLink);
        }if(webUrlToDeepLink.getWebURL().matches("(https://www.trendyol.com)(/tum-urunler)(.)(q=)(.*)")){
            return convertSearchpageResult(webUrlToDeepLink);
        }else return convertOtherpageResult(webUrlToDeepLink);
    }

    private WebUrlResultWrapper convertProductPageResult(@RequestBody WebUrlToDeepLink webUrlToDeepLink ){
        ProductPage productPage = productPageRequestParserService.parseProductRequest(webUrlToDeepLink.getWebURL());
        productPageService.save(productPage);
        String deeplink=productConvertorService.productPageConvert(productPage);
        ProductPageRequestResponseRecord productPageRequestResponseRecord=new ProductPageRequestResponseRecord(webUrlToDeepLink.getWebURL(),new Timestamp(new Date().getTime()),deeplink);
        productPageRequestResponseRecordService.save(productPageRequestResponseRecord);

        return new WebUrlResultWrapper(deeplink);
    }

    private WebUrlResultWrapper convertHomepageResult(@RequestBody WebUrlToDeepLink webUrlToDeepLink ){
        HomePage homePage = homePageRequestParserService.parseHomeRequest(webUrlToDeepLink.getWebURL());
        homePageService.save(homePage);
        String deeplink=homeConvertorService.homePageConvert(homePage);
        HomePageRequestResponseRecord homePageRequestResponseRecord=new HomePageRequestResponseRecord(webUrlToDeepLink.getWebURL(),new Timestamp(new Date().getTime()),deeplink);
        homePageRequestResponseRecordService.save(homePageRequestResponseRecord);

        return new WebUrlResultWrapper(deeplink);
    }

    private WebUrlResultWrapper convertSearchpageResult(@RequestBody WebUrlToDeepLink webUrlToDeepLink ){
        SearchPage searchPage= searchPageResultParserService.parseSearchRequest(webUrlToDeepLink.getWebURL());
        searchPageService.save(searchPage);
        String deeplink=searchConvertorService.searchPageConvert(searchPage);
        SearchPageRequestResponseRecord searchPageRequestResponseRecord=new SearchPageRequestResponseRecord(webUrlToDeepLink.getWebURL(),new Timestamp(new Date().getTime()),deeplink);
        searchPageRequestResponseRecordService.save(searchPageRequestResponseRecord);

        return new WebUrlResultWrapper(deeplink);
    }

    @RequestMapping(method=RequestMethod.POST, path = "/other-page-result",produces = MediaType.APPLICATION_JSON_VALUE)
    private WebUrlResultWrapper convertOtherpageResult(@RequestBody WebUrlToDeepLink webUrlToDeepLink ){
        OtherPageRequestResponseRecord otherPageRequestResponseRecord=new OtherPageRequestResponseRecord(webUrlToDeepLink.getWebURL(),new Timestamp(new Date().getTime()),"https://www.trendyol.com");
        otherPageRequestResponseRecordService.save(otherPageRequestResponseRecord);

        return new WebUrlResultWrapper("ty://?Page=Home");
    }


    public HomePageRequestParserService getHomePageRequestParserService() {
        return homePageRequestParserService;
    }

    public void setHomePageRequestParserService(HomePageRequestParserService homePageRequestParserService) {
        this.homePageRequestParserService = homePageRequestParserService;
    }

    public HomePageService getHomePageService() {
        return homePageService;
    }

    public void setHomePageService(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    public HomePageRequestResponseRecordService getHomePageRequestResponseRecordService() {
        return homePageRequestResponseRecordService;
    }

    public void setHomePageRequestResponseRecordService(HomePageRequestResponseRecordService homePageRequestResponseRecordService) {
        this.homePageRequestResponseRecordService = homePageRequestResponseRecordService;
    }

    public HomeConvertorService getHomeConvertorService() {
        return homeConvertorService;
    }

    public void setHomeConvertorService(HomeConvertorService homeConvertorService) {
        this.homeConvertorService = homeConvertorService;
    }
}
