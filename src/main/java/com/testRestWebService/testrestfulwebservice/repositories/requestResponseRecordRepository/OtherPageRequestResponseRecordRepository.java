package com.testRestWebService.testrestfulwebservice.repositories.requestResponseRecordRepository;

import com.testRestWebService.testrestfulwebservice.domain.mapper.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherPageRequestResponseRecordRepository extends CrudRepository<OtherPageRequestResponseRecord,Long> {
}
