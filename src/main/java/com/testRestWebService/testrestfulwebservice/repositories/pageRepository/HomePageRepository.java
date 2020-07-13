package com.testRestWebService.testrestfulwebservice.repositories.pageRepository;

import com.testRestWebService.testrestfulwebservice.domain.HomePage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomePageRepository extends CrudRepository<HomePage,Long> {
    Optional<HomePage> findBySectionName(String sectionname);
}
