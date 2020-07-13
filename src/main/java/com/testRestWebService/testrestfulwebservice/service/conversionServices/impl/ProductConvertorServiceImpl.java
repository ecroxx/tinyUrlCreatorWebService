package com.testRestWebService.testrestfulwebservice.service.conversionServices.impl;

import com.testRestWebService.testrestfulwebservice.domain.ProductPage;
import com.testRestWebService.testrestfulwebservice.service.conversionServices.ProductConvertorService;
import org.springframework.stereotype.Service;

@Service
public class ProductConvertorServiceImpl implements ProductConvertorService {
    public ProductConvertorServiceImpl() {
    }

    @Override
    public String productPageConvert(ProductPage productPage) {
        StringBuilder builder=new StringBuilder();
        builder.append("ty://?Page=").append(ProductPage.getPage()).append("&ContentId="+ productPage.getContentID());
        if(productPage.getButiqueID()!=null){builder.append("&CampaignId="+ productPage.getContentID());}
        if(productPage.getMercantID()!=null){builder.append("&MercantId="+ productPage.getMercantID());}
        return builder.toString();
    }
}
