package com.nideveloper.mvcTest.controllers;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.nideveloper.mvcTest.models.Person;


@Controller
public class WebController extends WebMvcConfigurerAdapter {

	private static Validator validator;
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @RequestMapping(value="/form", method=RequestMethod.GET)
    public ModelAndView showForm(Person person) {
    	
    	/*person = new Person();
    	person.setAge(23);
    	person.setName("");
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);*/
    	ModelAndView mav = new ModelAndView("template");
        mav.addObject("include", "form");
        return mav;
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public ModelAndView checkPersonInfo(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        	ModelAndView mav = new ModelAndView("template");
            mav.addObject("include", "form");
            return mav;
        }
        ModelAndView mav = new ModelAndView("redirect:/results");
        return mav;
    }

}
