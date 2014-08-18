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
	

}
