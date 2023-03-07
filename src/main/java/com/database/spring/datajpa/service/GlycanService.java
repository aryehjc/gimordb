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

    public Page<Glycan> getAllGlycans(int pageNumber, String sortField, String sortDir, int pagesize, String keyword)
    {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable paging = PageRequest.of(pageNumber - 1, pagesize, sort);

        Page<Glycan> pagedResult = repository.findAll(paging); //should be findbyDatabase?
        
        if (keyword != null) { 
          return repository.findByDatabaseid(keyword, paging); 
    }
         
        

        return pagedResult;
    }
}

       // Page<Glycan> pagedResult = repository.findAll(paging);
        

        //return pagedResult;
  //  }


//            if (keyword != null) { 
//                return glycanRepository.findAll(keyword, pageable);
//            }
//            
//		//		find all glycans data, then return it
//		return glycanRepository.findAll(pageable);
//	}
