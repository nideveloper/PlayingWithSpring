package com.nideveloper.mvcTest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.nideveloper.mvcTest.models.Blog.APIResponseContainer;
import com.nideveloper.mvcTest.models.fields.Field;
import com.nideveloper.mvcTest.models.fields.Radio;
import com.nideveloper.mvcTest.models.fields.RadioGroup;
import com.nideveloper.mvcTest.models.fields.TextBox;

@RestController
public class BlogController extends WebMvcConfigurerAdapter {
	private Twitter twitter;

    private ConnectionRepository connectionRepository;

    @Inject
    public void HelloController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }
    
	@RequestMapping(value="/")
    public ModelAndView loadHomePage() {
	 	RestTemplate restTemplate = new RestTemplate();
	 	APIResponseContainer latestBlogPosts = restTemplate.getForObject("http://www.nideveloper.co.uk/json", APIResponseContainer.class);
	 	List<Tweet> tweets = twitter.timelineOperations().getUserTimeline("nideveloper").subList(0, 5);

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("latestBlogPosts", latestBlogPosts.getPosts());
        mav.addObject("latestTweets", tweets);
        return mav;
    }
	
	@RequestMapping(value="/Screenbuilder")
    public ModelAndView loadScreenBuilderPage() {
	 	List<Field> fields = new ArrayList<Field>();
	 	
	 	TextBox textbox = new TextBox();
	 	textbox.setDisabled(false);
	 	textbox.setRequired(true);
	 	textbox.setValue("Test Value");
	 	textbox.addCssClass("testClass2");
	 	textbox.addCssClass("span12");
	 	textbox.setLabel("Field 1 :");
	 	textbox.setName("field1");
	 	textbox.setId("field1ID");
	 	
	 	TextBox textbox2 = new TextBox();
	 	textbox2.setDisabled(true);
	 	textbox2.setRequired(true);
	 	textbox2.setValue("Test Value");
	 	textbox2.setLabel("Field 2 :");
	 	textbox2.setName("field2");
	 	textbox2.setId("field2ID");
	 	
	 	TextBox textbox3 = new TextBox();
	 	textbox3.setDisabled(false);
	 	textbox3.setRequired(false);
	 	textbox3.setValue("Test Value");
	 	textbox3.setLabel("Field 3 :");
	 	textbox3.setName("field3");
	 	textbox3.setId("field3ID");
	 	
	 	RadioGroup radioGroup = new RadioGroup();
	 	radioGroup.setLabel("Radio Group :");
	 	radioGroup.setName("radioGroup");
	 	
	 	Radio radio1 = new Radio();
	 	radio1.setLabel("Option 1");
	 	radio1.setValue("option1");
	 	
	 	Radio radio2 = new Radio();
	 	radio2.setLabel("Option 2");
	 	radio2.setValue("option2");
	 	
	 	Radio radio3 = new Radio();
	 	radio3.setLabel("Option 3");
	 	radio3.setValue("option3");
	 	
	 	radioGroup.addRadioOption(radio1);
	 	radioGroup.addRadioOption(radio2);
	 	radioGroup.addRadioOption(radio3);
	 	
	 	
	 	fields.add(textbox);
	 	fields.add(textbox2);
	 	fields.add(textbox3);
	 	fields.add(radioGroup);

        ModelAndView mav = new ModelAndView("screenbuilder");
        mav.addObject("screenFields", fields);
        mav.addObject("screenFields2", fields);
        mav.addObject("sectionName", "Section Name");
        mav.addObject("section2Name", "Section 2 Name");
        return mav;
    }
}
