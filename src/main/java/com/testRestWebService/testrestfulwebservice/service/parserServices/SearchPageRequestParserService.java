package com.testRestWebService.testrestfulwebservice.service.parserServices;

import com.testRestWebService.testrestfulwebservice.domain.SearchPage;

public interface SearchPageRequestParserService {

    SearchPage parseSearchRequest(String request);
}
