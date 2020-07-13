package com.testRestWebService.testrestfulwebservice.service.parserServices;

import com.testRestWebService.testrestfulwebservice.domain.HomePage;

public interface HomePageRequestParserService {
    HomePage parseHomeRequest(String request);
}
