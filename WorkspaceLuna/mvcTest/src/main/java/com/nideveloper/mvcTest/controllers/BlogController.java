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
		 	List<Tweet> tweets = twitter.timelineOperations().getUserTimeline("nideveloper");
		 
		 	if(tweets.size()>5){
		 		List<Tweet> fiveTweets = new ArrayList<Tweet>(5);
		 		for(int i = 0; i< 5; i++){
		 			fiveTweets.add(tweets.get(i));
		 		}
		 		tweets = fiveTweets;
		 	}
		 	
	        ModelAndView mav = new ModelAndView("index");
	        mav.addObject("latestBlogPosts", latestBlogPosts.getPosts());
	        mav.addObject("latestTweets", tweets);
	        return mav;
	    }
	
	

    /*@RequestMapping(method=RequestMethod.GET)
    public String helloTwitter(Model model) {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
        	TwitterProfile profile = twitter.userOperations().getUserProfile("nideveloper");
        	
            return "redirect:/connect/twitter";
        }

        model.addAttribute(twitter.userOperations().getUserProfile());
        CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
        model.addAttribute("friends", friends);
        return "hello";
    }*/

}
