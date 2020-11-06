package com.skilldistillery.winenot.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.winenot.data.CustomerDAO;
import com.skilldistillery.winenot.data.ReviewDAO;
import com.skilldistillery.winenot.data.WineDAO;
import com.skilldistillery.winenot.entities.Customer;
import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.ReviewId;
import com.skilldistillery.winenot.entities.Wine;


@Controller
public class WineController {
	
	@Autowired
	private WineDAO wineDao;
	@Autowired
	private ReviewDAO reviewDao;
	@Autowired
	private CustomerDAO customerDao;
	
	@RequestMapping(path = {"/", "homePage.do"})
	public String index() {
		return "homePage";
	}

	//search by Wine ID
	@RequestMapping(path = "getWine.do", method = RequestMethod.GET)
	public String showWineId(HttpSession session,Integer wid, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		Wine wine = wineDao.findWineById(wid); 
		boolean favorited = false;

		boolean reviewFound = false;
		List<Review> reviews = wine.getReviews();
		if(customer != null) {
			favorited = customerDao.getCustomerFavorites(customer.getId()).contains(wine);
			if(reviewDao.getReviewByCustomerAndWineId(customer.getId(), wid) != null) {
				reviewFound = true;
				model.addAttribute("review", reviewDao.getReviewByCustomerAndWineId(customer.getId(), wid));
			} 
		} else {
		if(reviews.size() > 0) {
				Collections.shuffle(reviews);
				model.addAttribute("review", reviews.get(0));
			}
		}
		
		model.addAttribute("favorited", favorited);
		model.addAttribute("reviewed", reviewFound);
		model.addAttribute("wine", wine);
		return "show";
	}
	@RequestMapping(path = "getNextWine.do", method = RequestMethod.GET)
	public String getNextWine(HttpSession session,Integer wid, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		boolean favorited = false;
		Wine wine = null;
		//Loops to beginning of list
		List<Wine> wines = wineDao.findAllEnabledWine();
		if (wid == wines.get(wines.size()-1).getId()) {
			wine = wines.get(0);
		}  else {
			wid++;
			wine = wineDao.findWineById(wid); 
		}
		while (wine.getEnabled() == 0) {
			wid++;
			wine = wineDao.findWineById(wid);
		}
		
		boolean reviewFound = false;
		List<Review> reviews = wine.getReviews();
		if(customer != null) {
			favorited = customerDao.getCustomerFavorites(customer.getId()).contains(wine);
			if(reviewDao.getReviewByCustomerAndWineId(customer.getId(), wid) != null) {
				reviewFound = true;
				model.addAttribute("review", reviewDao.getReviewByCustomerAndWineId(customer.getId(), wid));
			} 
		} else {
			if(reviews.size() > 0) {
				Collections.shuffle(reviews);
				model.addAttribute("review", reviews.get(0));
			}
		}
		
		model.addAttribute("favorited", favorited);
		model.addAttribute("reviewed", reviewFound);
		model.addAttribute("wine", wine);
		return "show";
	}
	
	@RequestMapping(path = "getPreviousWine.do", method = RequestMethod.GET)
	public String getPreviousWine(HttpSession session,Integer wid, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		boolean favorited = false;
		//loops to end of list
		Wine wine = null;
		List<Wine> wines = wineDao.findAllEnabledWine();
		if (wid == wines.get(0).getId()) {
			wine = wines.get(wines.size()-1);
		}  else {
			wid--;
			wine = wineDao.findWineById(wid); 
		}
		while (wine.getEnabled() == 0) {
			wid--;
			wine = wineDao.findWineById(wid);
		}
		
		boolean reviewFound = false;
		List<Review> reviews = wine.getReviews();
		if(customer != null) {
			favorited = customerDao.getCustomerFavorites(customer.getId()).contains(wine);
			if(reviewDao.getReviewByCustomerAndWineId(customer.getId(), wid) != null) {
				reviewFound = true;
				model.addAttribute("review", reviewDao.getReviewByCustomerAndWineId(customer.getId(), wid));
			} 
		} else {
			if(reviews.size() > 0) {
				Collections.shuffle(reviews);
				model.addAttribute("review", reviews.get(0));
			}
		}
		
		model.addAttribute("favorited", favorited);
		model.addAttribute("reviewed", reviewFound);
		model.addAttribute("wine", wine);
		return "show";
	}
	
	
	//List of all wines
	@RequestMapping(path = "wineList.do", method = RequestMethod.GET)
	public String listedWines(Model model) {
		List<Wine> listOfWines = wineDao.findAllEnabledWine();
		model.addAttribute("wine", listOfWines);
		return "listOfWines";
	}
	//search by wine name
	@RequestMapping(path = "findWineName.do", method = RequestMethod.GET)
	public String findWineNames(String labelName, Model model) {
		List <Wine> findWinesByName = wineDao.findWineByName(labelName);
		model.addAttribute("wine", findWinesByName);
		return "listOfWines";
	}
	//list of wine types 
	@RequestMapping(path = "findWineType.do", method = RequestMethod.GET)
	public String findWineTypes(Integer id, Model model) {
		List<Wine> findWinesType = wineDao.findWineTypeId(id);
		model.addAttribute("wine", findWinesType);
		return "listOfWines";
	}
	//list of wine colors
	@RequestMapping(path = "findWineColor.do", method = RequestMethod.GET)
	public String findWineColors(Integer id, Model model) {
		List<Wine> findWinesColor = wineDao.findWineByWineColorId(id);
		model.addAttribute("wine", findWinesColor);
		return "listOfWines";
	}

//	//create wine 
//	@RequestMapping(path = "createWine.do", method = RequestMethod.POST)
//	public ModelAndView createWine(Wine wine, RedirectAttributes ra) {
//		Wine addWine = wineDao.createWine(wine);
//		
//		ModelAndView mv = new ModelAndView();
//		ra.addFlashAttribute("wine", addWine);
//		mv.setViewName("redirect:wineAdded.do");
//		return mv;
//	}
//	//newly created wine added 
//	@RequestMapping(path = "wineAdded.do", method = RequestMethod.GET)
//	public ModelAndView created() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("show");
//		return mv;
//	}

	//add review
	@RequestMapping(path = "addAReview.do")
	public String addAReview(HttpSession session, Model model, Integer custId, Integer wineId) {
		Customer customer = (Customer)session.getAttribute("customer");
		model.addAttribute("custId", customer.getId());
		model.addAttribute("wineId", wineId);
		Wine wine = wineDao.findWineById(wineId);
		model.addAttribute("wine", wine);
		return "addReview";
	}
	
	@RequestMapping(path = "addWineReview.do", method = RequestMethod.POST)
	public String submitWineReview(HttpSession session, Model model, Integer custId, Integer wineId, String review, Integer rating, String image) {
		Customer customer = (Customer)session.getAttribute("customer");
		ReviewId id = new ReviewId(customer.getId(), wineId);
		Review newReview = new Review();
		newReview.setId(id);
		newReview.setCustomer(customerDao.getCustomerById(customer.getId()));
		newReview.setWine(wineDao.findWineById(wineId));
		newReview.setReview(review);
		newReview.setRating(rating);
		newReview.setImage(image);
		reviewDao.createReview(newReview);
		List<Review> reviews = customerDao.getCustomerReviews(customer.getId());
		model.addAttribute("reviews", reviews);
//		ra.addFlashAttribute("reviews", reviews);
		return "redirect:reviewAdded.do";
	}
	@RequestMapping(path = "reviewAdded.do", method = RequestMethod.GET)
	public String reviewAdded(HttpSession session, Model model) {
		Customer customer = (Customer)session.getAttribute("customer");
		List<Review> reviews = customerDao.getCustomerReviews(customer.getId());
		model.addAttribute("reviews", reviews);
		return "myReviews";
	}
}
