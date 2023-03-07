package com.database.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.database.spring.datajpa.model.Glycan;

public interface GlycanRepository extends PagingAndSortingRepository<Glycan, Long> {
    
	Page<Glycan> findByDatabaseid(String databaseid, Pageable page);

}
