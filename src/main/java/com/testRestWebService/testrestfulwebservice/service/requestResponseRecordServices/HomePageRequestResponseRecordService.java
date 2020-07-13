package com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices;

import java.util.Optional;
import com.testRestWebService.testrestfulwebservice.domain.mapper.*;

public interface HomePageRequestResponseRecordService {

    Optional<HomePageRequestResponseRecord> findById(Long id);
    Iterable<HomePageRequestResponseRecord> getHomePages();
    void deleteById(Long id);
    void save(HomePageRequestResponseRecord homePageRequestResponseRecord);
}
