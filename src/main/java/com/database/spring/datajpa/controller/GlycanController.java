package com.database.spring.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import com.database.spring.datajpa.model.Glycan;
import com.database.spring.datajpa.service.GlycanService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;




@CrossOrigin(origins = "http://localhost:8081")
@Controller
public class GlycanController {

	@Autowired
	GlycanService glycanservice;
        
        //	display list of glycans
	@GetMapping("/search")
	// This means that this method will be executed when user sends GET Requests to "/"
	// In our case, "http://localhost:8080/"
	public String viewHomePage(Model model,
                                    @RequestParam(defaultValue = "1") int currentPage,
                                    @RequestParam(defaultValue = "5") Integer pageSize,
                                    @RequestParam(defaultValue = "neutralmass") String sortField,
                                    @RequestParam(defaultValue = "asc") String sortDir,
                                    @RequestParam(defaultValue = "0") String lower,
                                    @RequestParam(defaultValue = "100000") String upper,
                                    @Param("keyword") String keyword) {
		
            

     
            Page<Glycan> pages = glycanservice.getAllGlycans(currentPage, sortField, sortDir, pageSize, keyword, lower, upper);

            
            List<Glycan> listGlycans = pages.getContent(); 
  
            
            

            model.addAttribute("currentPage", currentPage);
            model.addAttribute("hasPrevious", pages.hasPrevious());
            model.addAttribute("hasNext", pages.hasNext());
            model.addAttribute("totalPages", pages.getTotalPages());
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("totalItems", pages.getTotalElements());
            
            model.addAttribute("sortField", sortField);
            model.addAttribute("sortDir", sortDir);
            model.addAttribute("keyword", keyword);
            
            model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
            
            
            model.addAttribute("listGlycans", listGlycans);
            
            return "index";
    }
	


}
