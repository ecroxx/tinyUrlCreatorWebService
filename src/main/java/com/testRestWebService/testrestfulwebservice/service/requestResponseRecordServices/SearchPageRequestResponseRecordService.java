package com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices;
import com.testRestWebService.testrestfulwebservice.domain.mapper.*;

import java.util.Optional;

public interface SearchPageRequestResponseRecordService {
    Optional<SearchPageRequestResponseRecord> findById(Long id);
    Iterable<SearchPageRequestResponseRecord> getHomePages();
    void deleteById(Long id);
    void save(SearchPageRequestResponseRecord searchPageRequestResponseRecord);
}
