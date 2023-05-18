package com.price.search.howmuchisit.domain.search.repository;

import com.price.search.howmuchisit.domain.search.entity.SearchLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLog, Long> {
}
