package com.database.spring.datajpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.database.spring.datajpa.model.Glycan;
import com.database.spring.datajpa.repository.GlycanRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.*;


@Service
public class GlycanService
{
    @Autowired
    GlycanRepository repository;

    public Page<Glycan> getAllGlycans(int pageNumber, String sortField, String sortDir, int pagesize, String keyword, String lower, String upper)
    {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable paging = PageRequest.of(pageNumber - 1, pagesize, sort);

        Page<Glycan> pagedResult = null;
        
        if (keyword != null) { 
          return repository.findByDatabaseid(keyword, paging);           
        }
        else if (upper != null && lower != null) {
            pagedResult = repository.findByMass(lower, upper, paging); // lower and upper mass supplied
        }
        else {
            pagedResult = repository.findAll(paging); // all the glycans are returned if no keyword or mass range supplied
        } 
        

        return pagedResult;
    }
}

