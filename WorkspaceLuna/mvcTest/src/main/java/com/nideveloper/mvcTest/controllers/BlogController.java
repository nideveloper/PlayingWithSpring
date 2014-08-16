package com.nideveloper.mvcTest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
public class BlogController extends WebMvcConfigurerAdapter {
	
	 @RequestMapping(value="/")
	    public ModelAndView loadHomePage() {
	        ModelAndView mav = new ModelAndView("index");
	        return mav;
	    }

}
