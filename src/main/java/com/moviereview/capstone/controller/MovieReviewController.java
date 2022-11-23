package com.moviereview.capstone.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.capstone.entity.Movie;
import com.moviereview.capstone.entity.Review;
import com.moviereview.capstone.entity.User;
import com.moviereview.capstone.repository.MovieRepository;
import com.moviereview.capstone.repository.ReviewRepository;
import com.moviereview.capstone.repository.UserRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api/v1")
public class MovieReviewController { 
	
	@Autowired
	private MovieRepository movieRepo;
	
	@PostMapping(value="/addMovie")
	public void addMovie(@RequestBody Movie v) {
		System.out.println("Movie Id"+v.getId());
		System.out.println("Movie Name"+v.getName())
		
		

;		movieRepo.save(v);
		
	}
	
	@GetMapping(value="/listMovie")
	public List<Movie> listMovies() {
		List<Movie> moviesList=movieRepo.findAll();
		return moviesList;
		
	}
	

	private ReviewRepository ReviewRepo;

	@PostMapping(value="/addReview")
	public void addReview(Review v) {
		ReviewRepo.save(v);
}
	@GetMapping(value="/listReviews")
	public List<Review> listReviews() {
		List<Review> reviewsList=ReviewRepo.findAll();
		return reviewsList;
		
}
	
	
	private UserRepository userRepo;
	
	@PostMapping(value="/addUser")
	public void addUser(User v) {
		userRepo.save(v);
}
	@GetMapping(value="/listUsers")
	public List<User> listUsers() {
		List<User> userList=userRepo.findAll();
		return userList;
}
}