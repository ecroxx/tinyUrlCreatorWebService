package com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices;
import com.testRestWebService.testrestfulwebservice.domain.mapper.*;

import java.util.Optional;

public interface OtherPageRequestResponseRecordService {
    Optional<OtherPageRequestResponseRecord> findById(Long id);
    Iterable<OtherPageRequestResponseRecord> getHomePages();
    void deleteById(Long id);
    void save(OtherPageRequestResponseRecord otherPageRequestResponseRecord);
}
