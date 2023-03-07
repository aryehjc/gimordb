package com.database.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import com.database.spring.datajpa.model.Glycan;

public interface GlycanRepository extends PagingAndSortingRepository<Glycan, Long> {
    
	Page<Glycan> findByDatabaseid(String databaseid, Pageable page);

        
        @Query("select g from Glycan g where g.neutralmass >= ?1 AND g.neutralmass <= ?2")
        Page<Glycan> findByMass(String lower, String upper, Pageable page);
}
