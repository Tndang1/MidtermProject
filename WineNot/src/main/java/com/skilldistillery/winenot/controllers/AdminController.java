package com.skilldistillery.winenot.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.winenot.data.AddressDAO;
import com.skilldistillery.winenot.data.CustomerDAO;
import com.skilldistillery.winenot.data.CustomerOrderDAO;
import com.skilldistillery.winenot.data.PaymentInfoDAO;
import com.skilldistillery.winenot.data.ReviewDAO;
import com.skilldistillery.winenot.data.UserDAO;
import com.skilldistillery.winenot.data.WineColorTypeDAO;
import com.skilldistillery.winenot.data.WineDAO;
import com.skilldistillery.winenot.entities.Customer;
import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.ReviewId;
import com.skilldistillery.winenot.entities.User;
import com.skilldistillery.winenot.entities.Wine;
import com.skilldistillery.winenot.entities.WineColor;

@Controller
public class AdminController {

	@Autowired
	private CustomerDAO custDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private AddressDAO addrDAO;
	@Autowired
	private CustomerOrderDAO custOrdDAO;
	@Autowired
	private PaymentInfoDAO payInfoDAO;
	@Autowired
	private ReviewDAO rviewDAO;
	@Autowired
	private WineDAO wDAO;
	@Autowired
	private WineColorTypeDAO colorTypeDAO;
	
	//*******Admin Navigation********
	@RequestMapping(path = "admin.do")
	public String adminPage(HttpSession session, Model model) {
		model.addAttribute("customer", session.getAttribute("customer"));
		return "admin";
	}
	@RequestMapping(path = "adminWineForm.do", method = RequestMethod.GET)
	public String addWineForm(HttpSession session, Model model) {
		model.addAttribute("customer", session.getAttribute("customer"));
		return "adminFiles/adminAddAWine";
	}
	@RequestMapping(path="adminUpdateWineForm.do", method = RequestMethod.GET)
	public String updateWineForm(Model model, int wineId) {
		Wine wine = wDAO.findWineById(wineId);
		model.addAttribute("wine", wine);
		return "adminFiles/adminUpdateAWine";
	}
	@RequestMapping(path="adminUpdateUserForm.do", method = RequestMethod.GET)
	public String updateUserForm(Model model, int userId) {
		User user = userDAO.getUserById(userId);
		model.addAttribute("user", user);
		return "adminFiles/adminUpdateAUser";
	}
	@RequestMapping(path="adminUpdateReviewForm.do", method = RequestMethod.GET)
	public String updateReviewFrom(Model model, int custId, int wineId) {
		Review review = rviewDAO.getReviewByCustomerAndWineId(custId, wineId);
		model.addAttribute("review", review);
		return "adminFiles/adminUpdateAReview";
	}
	
	//********Admin review controls***********
	@RequestMapping(path = "adminReviewList.do", method = RequestMethod.GET)
	public String adminReviewList(Model model) {
		List<Review> review = rviewDAO.getAllReviews();
		model.addAttribute("reviewResults", review);
		return "admin";
	}
	@RequestMapping(path = "adminDeleteReview.do", method = RequestMethod.GET)
	public String adminDeleteReview(Model model, int custId, int wineId) {
		boolean deleted = rviewDAO.deleteReview(custId, wineId);
		model.addAttribute("deleted", deleted);
		return "admin";
	}
	@RequestMapping(path = "adminUpdateReview.do", method = RequestMethod.GET)
	public String adminUpdateReview(Model model, int custId, int wineId, String review, Integer rating, String image) {
		Review updateReview = new Review();
		Wine wine = wDAO.findWineById(wineId);
		Customer customer = custDAO.getCustomerById(custId);
		updateReview.setReview(review);
		updateReview.setRating(rating);
		updateReview.setImage(image);
		updateReview.setWine(wine);
		updateReview.setCustomer(customer);
		rviewDAO.updateReview(custId, wineId, updateReview);
		return "admin";
	}
	
	//*******Admin wine controls**********
	@RequestMapping(path = "adminWineList.do", method = RequestMethod.GET)
	public String adminWineList(HttpSession session, Model model) {
		List<Wine> wines = wDAO.findAllWine();
		model.addAttribute("wineResults", wines);
		return "admin";
	}
	@RequestMapping(path="adminDisableWine.do", method = RequestMethod.GET)
	public String adminDisableWine(Model model, int wineId) {
		boolean disabled = wDAO.disableWine(wineId);
		model.addAttribute("disabled", disabled);
		return "admin";
	}
	@RequestMapping(path="adminEnableWine.do", method = RequestMethod.GET)
	public String adminEnableWine(Model model, int wineId) {
		boolean enabled = wDAO.enableWine(wineId);
		model.addAttribute("enabled", enabled);
		return "admin";
	}
	@RequestMapping(path="adminUpdateWine.do", method = RequestMethod.GET)
	public String adminUpdateWine(Model model, int wineId, String labelName, String vineyard, Integer vintageYear, String flavor, String dietary, String description, String image, String pairs, Integer wineType, Integer wineColor) {
		Wine wine = new Wine();
		wine.setId(wineId);
		wine.setDescription(description);
		wine.setDietary(dietary);
		wine.setEnabled(1);
		wine.setFlavor(flavor);
		wine.setImage(image);
		wine.setLabelName(labelName);
		wine.setPairs(pairs);
		wine.setVineyard(vineyard);
		wine.setVintageYear(vintageYear);
		wine.setWineColor(colorTypeDAO.findColorById(wineColor));
		wine.setWineType(colorTypeDAO.findTypeById(wineType));
		Wine updated = wDAO.updateWine(wine);
		model.addAttribute("wine", updated);
		return null;
	}
	@RequestMapping(path="adminAddWine.do", method = RequestMethod.GET)
	public String adminAddWine(Model model, String labelName, String vineyard, Integer vintageYear, String flavor, String dietary, String description, String image, String pairs, Integer wineType, Integer wineColor) {
		Wine wine = new Wine();
		wine.setDescription(description);
		wine.setDietary(dietary);
		wine.setEnabled(1);
		wine.setFlavor(flavor);
		wine.setImage(image);
		wine.setLabelName(labelName);
		wine.setPairs(pairs);
		wine.setVineyard(vineyard);
		wine.setVintageYear(vintageYear);
		wine.setWineColor(colorTypeDAO.findColorById(wineColor));
		wine.setWineType(colorTypeDAO.findTypeById(wineType));
		wDAO.createWine(wine);
		return "admin";
	}
	
	//*******Admin user controls***************
	@RequestMapping(path="adminUserList.do", method = RequestMethod.GET)
	public String adminUserList(Model model) {
		List<User> user = userDAO.getAllUsers();
		model.addAttribute("userResults", user);
		return "admin";
	}
	@RequestMapping(path="adminDisableUser.do", method = RequestMethod.GET)
	public String adminDisableUser(Model model, int userId) {
		boolean disabled = userDAO.disableUser(userId);
		model.addAttribute("disabled", disabled);
		return "admin";
	}
	@RequestMapping(path="adminEnableUser.do", method = RequestMethod.GET)
	public String adminEnableUser(Model model, int userId) {
		boolean enabled = userDAO.enableUser(userId);
		model.addAttribute("enabled", enabled);
		return "admin";
	}
	@RequestMapping(path="adminUpdateUser.do", method = RequestMethod.GET)
	public String adminUpdateUser(Model model, int userId, int enabled, String username, String email, String password, String role) {
		User user = new User();
		user.setEnabled(enabled);
		user.setUsername(username);
		user.setEmail(email);
		user.setId(userId);
		user.setPassword(password);
		user.setRole(role);
		User updated = userDAO.updateUser(userId, user);
		model.addAttribute("user", updated);
		return "admin";
	}
	
}
