package com.skilldistillery.winenot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.skilldistillery.winenot.data.WineDAO;
import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.Wine;


@Controller
public class WineController {
	
	@Autowired
	private WineDAO wineDao;
//	private WineTypeDAO wineTypeDao;
//	private WineColorDAO wineColorDao;
//	private ReviewDAO reviewDao;
	
	
	//
	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}
	//search by Wine ID
	@RequestMapping(path = "getWine.do", method = RequestMethod.GET)
	public String showWineId(Integer wid, Model model) {
		Wine wine = wineDao.findWineById(wid);
		List<Review> reviews = wine.getReviews();
		model.addAttribute("review", reviews.get((int)(Math.random() * (reviews.size()-1))));
		model.addAttribute("wine", wine);
		return "show";
	}
	//List of all wines
	@RequestMapping(path = "wineList.do", method = RequestMethod.GET)
	public String listedWines(Model model) {
		List<Wine> listOfWines = wineDao.findAllWine();
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
		return "";
	}
	//list of wine colors
	@RequestMapping(path = "findWineColor.do", method = RequestMethod.GET)
	public String findWineColors(Integer id, Model model) {
		List<Wine> findWinesColor = wineDao.findWineByWineColorId(id);
		model.addAttribute("wine", findWinesColor);
		return "";
	}
	//list of reviews
	@RequestMapping(path = "reviewsList.do", method = RequestMethod.GET)
	public String listedReviews (Integer id, Model model) {
		List<Review> listOfReviews = wineDao.getCustomerReviews(id);
		model.addAttribute("wine", listOfReviews);
		return "";
	}
	//create wine 
	@RequestMapping(path = "createWine.do", method = RequestMethod.POST)
	public ModelAndView createWine(Wine wine, RedirectAttributes ra) {
		Wine addWine = wineDao.createWine(wine);
		
		ModelAndView mv = new ModelAndView();
		ra.addFlashAttribute("wine", addWine);
		mv.setViewName("redirect:wineAdded.do");
		return mv;
	}
	//newly created wine added 
	@RequestMapping(path = "wineAdded.do", method = RequestMethod.GET)
	public ModelAndView created() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");
		return mv;
	}
	//update wine
	@RequestMapping(path="updatedWine.do", method = RequestMethod.POST)
	public ModelAndView createUpdatedWine(Integer id, Wine wine) {
		ModelAndView mv = new ModelAndView();
		Wine updatedWine = wineDao.findWineById(id);
		mv.addObject("wine", updatedWine);
		mv.setViewName("redirect:updateThisWineNow.do");
		return mv;
	}
	//updated by redirect
	@RequestMapping(path="updateThisWineNow.do", method = RequestMethod.POST) 
	public ModelAndView update(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("wine", wineDao.findWineById(id));
		mv.setViewName("updateWine");
		return mv;
		
	}
	//display updated wine
	@RequestMapping(path="Update.do", method = RequestMethod.POST) 
	public ModelAndView updateConfirmation(Wine wine) {
		ModelAndView mv = new ModelAndView();
		wineDao.updateWine(wine);
		mv.addObject("wine", wine);
		mv.setViewName("updatedWinePage");
		return mv;
		
	}
	//delete wine
	@RequestMapping(path="deletedWine.do", method = RequestMethod.GET)
	public ModelAndView showDeletedWine(Integer id) {
		wineDao.deleteWine(id);
		ModelAndView mv = new ModelAndView();
//		ra.addFlashAttribute("wine", deleteThisWine);
		mv.setViewName("deleteWine");
		return mv;
	}
	
	
	
	//home page
	@RequestMapping(path = "index.do")
	public String backHome() {
		return "index";
	}
}
