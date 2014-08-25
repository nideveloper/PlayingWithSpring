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
	
	private List<Field> getFields(){
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
	 	
	 	TextBox textbox4 = new TextBox();
	 	textbox4.setDisabled(true);
	 	textbox4.setRequired(true);
	 	textbox4.setValue("Test Value");
	 	textbox4.setLabel("Field 4 :");
	 	textbox4.setName("field4");
	 	textbox4.setId("field4ID");
	 	
	 	TextBox textbox5 = new TextBox();
	 	textbox5.setDisabled(false);
	 	textbox5.setRequired(false);
	 	textbox5.setValue("Test Value");
	 	textbox5.setLabel("Field 5 :");
	 	textbox5.setName("field5");
	 	textbox5.setId("field5ID");
	 	textbox5.setNumColumns(12);
	 	
	 	RadioGroup radioGroup = new RadioGroup();
	 	radioGroup.setLabel("Radio Group :");
	 	radioGroup.setName("radioGroup");
	 	radioGroup.setNumColumns(12);
	 	
	 	Radio radio1 = new Radio();
	 	radio1.setLabel("This is the first option");
	 	radio1.setValue("option1");
	 	
	 	Radio radio2 = new Radio();
	 	radio2.setLabel("This is the second option");
	 	radio2.setValue("option2");
	 	
	 	Radio radio3 = new Radio();
	 	radio3.setLabel("This is the third option");
	 	radio3.setValue("option3");
	 	
	 	radioGroup.addRadioOption(radio1);
	 	radioGroup.addRadioOption(radio2);
	 	radioGroup.addRadioOption(radio3);
	 	
	 	
	 	fields.add(textbox);
	 	fields.add(radioGroup);
	 	fields.add(textbox2);
	 	fields.add(textbox3);
	 	fields.add(textbox4);
	 	fields.add(textbox5);
	 	
	 	return fields;
	}
	
	@RequestMapping(value="/Screenbuilder")
    public ModelAndView loadScreenBuilderPage() {

        ModelAndView mav = new ModelAndView("screenbuilder");
        mav.addObject("screenFields", getFields());
        mav.addObject("screenFields2", getFields());
        mav.addObject("sectionName", "Section Name");
        mav.addObject("section2Name", "Three Column Section, same fields");
        return mav;
    }
}
