/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database.spring.datajpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
            
            
                return "homepage";
	}
        
        
        @GetMapping("/listall")
        public String help() {
            
            return "list-glycans";
            // make the htmls as usual and then just put them in the controller. and then add it to te 
        }


}
