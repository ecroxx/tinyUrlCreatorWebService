package com.testRestWebService.testrestfulwebservice.repositories.pageRepository;

import com.testRestWebService.testrestfulwebservice.domain.SearchPage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SearchPageRepository extends CrudRepository<SearchPage,Long> {
    Optional<SearchPage> findByQuery(String query);

}
