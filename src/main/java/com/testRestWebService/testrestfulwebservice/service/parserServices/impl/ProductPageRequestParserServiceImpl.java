package com.testRestWebService.testrestfulwebservice.service.parserServices.impl;

import com.testRestWebService.testrestfulwebservice.domain.ProductPage;
import com.testRestWebService.testrestfulwebservice.service.parserServices.ProductPageRequestParserService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProductPageRequestParserServiceImpl implements ProductPageRequestParserService {

 public ProductPage parseProductRequest(String request){
     ProductPage productPage =new ProductPage();

     String regexOfPattern = "(https://www.trendyol.com/)(.*)(/)(.*)(-p-)(\\d+)((.)((boutiqueId=)(\\d+))?(&)?((merchantId=)(\\d+))?)?";
     Pattern pattern = Pattern.compile(regexOfPattern);
     Matcher matcher = pattern.matcher(request);
     if (matcher.find( )) {
         productPage.setWebURL(request);
         productPage.setDomain(matcher.group(1));
         productPage.setBrandName(matcher.group(2));
         productPage.setProductName(matcher.group(4));
         productPage.setContentID(Integer.valueOf(matcher.group(6)));
         if(matcher.group(11)!=null){
             productPage.setButiqueID(Integer.valueOf(matcher.group(11)));
         }
         if(matcher.group(15)!=null){
             productPage.setMercantID(Integer.valueOf(matcher.group(15)));
         }
     }
     return productPage;
 }



}
