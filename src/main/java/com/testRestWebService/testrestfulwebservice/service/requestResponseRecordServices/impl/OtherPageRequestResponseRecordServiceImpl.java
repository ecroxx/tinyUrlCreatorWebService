package com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.impl;

import com.testRestWebService.testrestfulwebservice.repositories.requestResponseRecordRepository.OtherPageRequestResponseRecordRepository;
import com.testRestWebService.testrestfulwebservice.service.requestResponseRecordServices.OtherPageRequestResponseRecordService;
import org.springframework.stereotype.Service;
import com.testRestWebService.testrestfulwebservice.domain.mapper.*;


import java.util.Optional;

@Service
public class OtherPageRequestResponseRecordServiceImpl implements OtherPageRequestResponseRecordService {

    private OtherPageRequestResponseRecordRepository otherPageRequestResponseRecordRepository;

    public OtherPageRequestResponseRecordServiceImpl(OtherPageRequestResponseRecordRepository otherPageRequestResponseRecordRepository) {
        this.otherPageRequestResponseRecordRepository = otherPageRequestResponseRecordRepository;
    }

    public OtherPageRequestResponseRecordRepository getOtherPageRequestResponseRecordRepository() {
        return otherPageRequestResponseRecordRepository;
    }

    public void setOtherPageRequestResponseRecordRepository(OtherPageRequestResponseRecordRepository otherPageRequestResponseRecordRepository) {
        this.otherPageRequestResponseRecordRepository = otherPageRequestResponseRecordRepository;
    }

    @Override
    public Optional<OtherPageRequestResponseRecord> findById(Long id) {
        return otherPageRequestResponseRecordRepository.findById(id);
    }

    @Override
    public Iterable<OtherPageRequestResponseRecord> getHomePages() {
        return otherPageRequestResponseRecordRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        otherPageRequestResponseRecordRepository.deleteById(id);
    }

    @Override
    public void save(OtherPageRequestResponseRecord otherPageRequestResponseRecord) {
        otherPageRequestResponseRecordRepository.save(otherPageRequestResponseRecord);
    }
}
