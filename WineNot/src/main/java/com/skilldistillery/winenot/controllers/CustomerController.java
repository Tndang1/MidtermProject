package com.skilldistillery.winenot.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.winenot.data.AddressDAO;
import com.skilldistillery.winenot.data.CustomerDAO;
import com.skilldistillery.winenot.data.CustomerOrderDAO;
import com.skilldistillery.winenot.data.PaymentInfoDAO;
import com.skilldistillery.winenot.data.ReviewDAO;
import com.skilldistillery.winenot.data.UserDAO;
import com.skilldistillery.winenot.data.WineDAO;
import com.skilldistillery.winenot.entities.Address;
import com.skilldistillery.winenot.entities.Customer;
import com.skilldistillery.winenot.entities.CustomerOrder;
import com.skilldistillery.winenot.entities.PaymentInfo;
import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.User;
import com.skilldistillery.winenot.entities.Wine;

@Controller
public class CustomerController {

	// All DAOS that could be implemented by the Customer ==================

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

	// REQUEST MAPPING ======================================================

	@RequestMapping(path = "index.html")
	public String index(Model model) {
		return "index.html";
	}

	// USER FORMS ================

	@RequestMapping(path = "createUserForm.do", method = RequestMethod.GET)
	public String createUserForm(User user) {
		return "LogIn";
//		return "folder/newUserForm";
	}

	@RequestMapping(path = "createUser.do", method = RequestMethod.POST)
	public String createUser(User user, Model model) {
		model.addAttribute("newUser", userDAO.createUser(user));

//		return "folder/userProfilePage";
		return "userProfilePage";
	}
	@RequestMapping(path = "createCustomerForm.do")
	public String createAccount() {
		
		return "createNewAccount";
	}
	@RequestMapping(path = "createCustomer.do", method = RequestMethod.POST)
	public String createNewAccount(HttpSession session, Model model, User user, String date, String firstName, String lastName) {
		User newUser = userDAO.createUser(user);
		Customer customer = new Customer();
		customer.setUser(newUser);
		customer.setfName(firstName);
		customer.setlName(lastName);
		LocalDateTime createDate = LocalDateTime.now();
//		System.out.println(date);
		LocalDate birthDate = LocalDate.parse(date);
		LocalDateTime bornDate = birthDate.atStartOfDay();
//		System.out.println(birthDate);
		customer.setBirthdate(bornDate);
		customer.setCreateDate(createDate);
		customer = custDAO.createCustomer(customer);
		model.addAttribute("newAccount", newUser);
		if (session.getAttribute("customer") == null) {
		session.setAttribute("customer", customer);
		}
		return "createNewAccount";
	}

	@RequestMapping(path = "updateUserForm.do")
	public String updateUsernameById(HttpSession session, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		User updateUser = userDAO.getUserById(customer.getId());
		model.addAttribute("user", updateUser);
		return "userProfilePage";
	}
	@RequestMapping(path = "updateUsernameForm.do")
	public String updateUsername(HttpSession session, Model model, String username) {
		Customer customer = (Customer) session.getAttribute("customer");
		User updateUser = userDAO.getUserById(customer.getId());
		updateUser.setUsername(username);
		userDAO.updateUser(customer.getId(), updateUser);
		model.addAttribute("user", updateUser);
		return "userProfilePage";
	}

	@RequestMapping(path = "updatePasswordForm.do")
	public String updatePass(HttpSession session, Model model, String pass) {
		Customer customer = (Customer) session.getAttribute("customer");
		User updateUser = userDAO.getUserById(customer.getId());
		updateUser.setPassword(pass);
		userDAO.updateUser(customer.getId(), updateUser);
		model.addAttribute("user", updateUser);
		return "userProfilePage";
	}

	@RequestMapping(path = "updateEmailForm.do")
	public String updateEmail(HttpSession session, Model model, String email) {
		Customer customer = (Customer) session.getAttribute("customer");
		User updateUser = userDAO.getUserById(customer.getId());
		updateUser.setEmail(email);
		userDAO.updateUser(customer.getId(), updateUser);
		model.addAttribute("user", updateUser);
		return "userProfilePage";
	}

	@RequestMapping(path = "deleteUser.do")
	public String deleteUser(HttpSession session, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (custDAO.deleteCustomer(customer.getId())) {
			model.addAttribute("deleteResult", "Customer Account deleted");
		}

		else {
			model.addAttribute("deleteResult", "Customer account not found");
		}

		return "homePage";
	}

	// ADDRESS FORMS =================

	@RequestMapping(path = "createAddressForm.do", method = RequestMethod.GET)
	public String CreateAddressForm(HttpSession session, Address Address) {
		Customer customer = (Customer) session.getAttribute("customer");

		return "address";
	}

	@RequestMapping(path = "createAddress.do", method = RequestMethod.POST)
	public String createAddress(HttpSession session, Address address, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("newAddress", addrDAO.createAddress(address));

		return "address";
	}
	@RequestMapping(path = "updateAddressForm.do", method = RequestMethod.GET)
	public String updateAddress(HttpSession session, String newAddy, Integer id, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		Address address = addrDAO.getAddressById(customer.getAddress().getId());
		address.setStreet(newAddy);
		address.setStreet2(newAddy);
		address.setCity(newAddy);
		address.setState(newAddy);
		address.setZip(newAddy);
		
		model.addAttribute("address", addrDAO.updateAddress(id, address));
		return "updateAddress";
	}
	@RequestMapping(path = "deleteAddressForm.do", method = RequestMethod.GET)
	public String deleteAddress(HttpSession session, Integer id, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		Boolean deleted = addrDAO.deleteAddress(id);
		Address address = addrDAO.getAddressById(customer.getId());
		model.addAttribute("address", address);
		model.addAttribute("deleted", deleted);
		return "updateAddress";
	}
//	@RequestMapping(path = "removeReview.do", method = RequestMethod.GET)
//	public String removeReview(HttpSession session, Model model, int wineId) {
//	Customer customer = (Customer) session.getAttribute("customer");
//	Boolean deleted = rviewDAO.deleteReview(customer.getId(), wineId);
//	List<Review> reviews = custDAO.getCustomerReviews(customer.getId());
//	model.addAttribute("reviews", reviews);
//	model.addAttribute("deleted", deleted);
//	return "myReviews";
//}
	
	
	
	
//	@RequestMapping(path = "updateReviewReview.do", method = RequestMethod.GET)
//	public String updateReviewReview(HttpSession session, Model model, int wineId, String reviewUpdate) {
//		Customer customer = (Customer) session.getAttribute("customer");
//		Review review = rviewDAO.getReviewByCustomerAndWineId(customer.getId(), wineId);
//		review.setReview(reviewUpdate);
//		rviewDAO.updateReview(customer.getId(), wineId, review);
//		List<Review> reviews = custDAO.getCustomerReviews(customer.getId());
//		model.addAttribute("reviews", reviews);
//		return "myReviews";
//	}

	// PAYMENT FORMS =================

	@RequestMapping(path = "createPaymentInfoForm.do", method = RequestMethod.GET)
	public String createPayInfoForm(HttpSession session, Model model, PaymentInfo payInfo) {
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("payInfo", customer.getPaymentInfo());

		return "payment";
	}

	@RequestMapping(path = "createPaymentInfo.do", method = RequestMethod.POST)
	public String createPayInfo(HttpSession session, PaymentInfo payInfo, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("newUser", payInfoDAO.create(payInfo));

		return "payment";
	}

	// REVIEW FORMS =====================

	@RequestMapping(path = "createReviewForm.do", method = RequestMethod.GET)
	public String createReviewForm(HttpSession session, Review review) {

		return "folder/reviewsForm";
	}

	@RequestMapping(path = "createReview.do", method = RequestMethod.POST)
	public String createReview(HttpSession session, Review review, Model model) {
		model.addAttribute("review", rviewDAO.createReview(review));

		return "folder/userProfilePage";
	}
	
//	@RequestMapping(path = "getCustomerReviews.do", method = RequestMethod.GET)
//	public String getAllReviews(Model model, int id) {
//		Customer customer = custDAO.getCustomerById(id); 
//		List<Review> listReviews = customer.getReviews();
//		model.addAttribute("reviews", listReviews);
//		
	//displays the list of reviews currently
	@RequestMapping(path = "getAllReviews.do", method = RequestMethod.GET)
	public String getAllReviews(HttpSession session, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		List<Review> reviews = custDAO.getCustomerReviews(customer.getId());
		model.addAttribute("reviews", reviews);
		return "myReviews";
	}

	//goes to the form to update review of wines.
	@RequestMapping(path = "getUpdatedReviewOfWines.do", method = RequestMethod.GET)
	public String getUpdatedReviewOfWiines(HttpSession session, Model model, int custId, int wineId) {
		Customer customer = (Customer) session.getAttribute("customer");
//		List<Review> reviews = custDAO.getCustomerReviews(customer.getId());
		Review review = rviewDAO.getReviewByCustomerAndWineId(custId, wineId);
		model.addAttribute("review", review);
		model.addAttribute("custId", custId);
		model.addAttribute("wineId", wineId);
		return "updateReviewWine";
	}
	//redisplay the updated wines back to the reviews page.
	@RequestMapping(path = "getAllUpdatedReviews.do", method = RequestMethod.GET)
	public String getAllUpdatedReviews(HttpSession session, Model model, int wineId, String reviewUpdate, int rating, String image) {
		Customer customer = (Customer) session.getAttribute("customer");
		Review review = rviewDAO.getReviewByCustomerAndWineId(customer.getId(), wineId);
		review.setReview(reviewUpdate);
//		rviewDAO.updateReview(customer.getId(), wineId, review);
		review.setRating(rating);
//		rviewDAO.updateReview(customer.getId(), wineId, review);
		review.setImage(image);
		rviewDAO.updateReview(customer.getId(), wineId, review);
		List<Review> reviews = custDAO.getCustomerReviews(customer.getId());
		model.addAttribute("reviews", reviews);
		return "myReviews";
	}
	@RequestMapping(path = "getAllReviewsUpdated.do", method = RequestMethod.GET)
	public String getAllReviewsUpdated(HttpSession session, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		List<Review> reviews = custDAO.getCustomerReviews(customer.getId());
		model.addAttribute("reviews", reviews);
		return "myReviews";
	}
	@RequestMapping(path = "removeReview.do", method = RequestMethod.GET)
	public String removeReview(HttpSession session, Model model, int wineId) {
		Customer customer = (Customer) session.getAttribute("customer");
		Boolean deleted = rviewDAO.deleteReview(customer.getId(), wineId);
		List<Review> reviews = custDAO.getCustomerReviews(customer.getId());
		model.addAttribute("reviews", reviews);
		model.addAttribute("deleted", deleted);
		return "myReviews";
	}
	
//	@RequestMapping(path = "updateReviewReview.do", method = RequestMethod.GET)
//	public String updateReviewReview(HttpSession session, Model model, int wineId, String reviewUpdate, String image) {
//		Customer customer = (Customer) session.getAttribute("customer");
//		Review review = rviewDAO.getReviewByCustomerAndWineId(customer.getId(), wineId);
//		review.setReview(reviewUpdate);
//		rviewDAO.updateReview(customer.getId(), wineId, review);
//		List<Review> reviews = custDAO.getCustomerReviews(customer.getId());
//		model.addAttribute("reviews", reviews);
//		return "myReviews";
//	}
//	@RequestMapping(path = "updateReviewRating.do", method = RequestMethod.GET)
//	public String updateReviewRating(HttpSession session, Model model, int wineId, int rating) {
//		Customer customer = (Customer) session.getAttribute("customer");
//		Review review = rviewDAO.getReviewByCustomerAndWineId(customer.getId(), wineId);
//		review.setRating(rating);
//		rviewDAO.updateReview(customer.getId(), wineId, review);
//		List<Review> reviews = custDAO.getCustomerReviews(customer.getId());
//		model.addAttribute("reviews", reviews);
//		return "myReviews";
//	}
//	@RequestMapping(path = "updateReviewImage.do", method = RequestMethod.GET)
//	public String updateReviewImage(HttpSession session, Model model, int wineId, String image) {
//		Customer customer = (Customer) session.getAttribute("customer");
//		Review review = rviewDAO.getReviewByCustomerAndWineId(customer.getId(), wineId);
//		review.setImage(image);
//		rviewDAO.updateReview(customer.getId(), wineId, review);
//		List<Review> reviews = custDAO.getCustomerReviews(customer.getId());
//		model.addAttribute("reviews", reviews);
//		return "myReviews";
//	}
	

	// FAVORITES FORMS ===================
	
	@RequestMapping(path = "favoritesList.do")
	public String getFavorites(HttpSession session, Model model, Integer id) {
		Customer customer = (Customer) session.getAttribute("customer");
		List<Wine> cust = custDAO.getCustomerFavorites(customer.getId());
		model.addAttribute("favList", cust);
		
		return "favorites";
	}
	
	@RequestMapping(path = "addToFavoritesList.do")
	public String addToFavorites(HttpSession session, Model model, Integer id, Integer wid) {
		Customer customer = (Customer) session.getAttribute("customer");
		List<Wine> cust = custDAO.addWineToFavorites(customer.getId(), wid);
		model.addAttribute("favList", cust);
		
		return "favorites";
	}

	
	//ORDER FORMS ========================
	@RequestMapping(path ="listAllCustomerOrders.do", method = RequestMethod.GET)
	public String listAllCustomerOrders(HttpSession session, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		List<CustomerOrder> orders = custDAO.getCustomerOrders(customer.getId());
		model.addAttribute("orders", orders);
		
		return "orderhistory";
	}
	
	//Login in
	@RequestMapping(path="checkCredentials.do", method = RequestMethod.GET)
	public String checkCredentials(HttpSession session, Model model, String email, String password) {
		Customer customer = custDAO.verifyLogin(email, password);
		if (customer == null) {
			String failure = "Invalid login credentials, try again or create and account.";
			model.addAttribute("failure", failure);
			return "LogIn";
		}
		if (session.getAttribute("customer") == null) {
		session.setAttribute("customer", customer);
		}
		model.addAttribute("customerId", customer.getId());
		return "homePage";
	}
	//Log Out 
	@RequestMapping(path="logOutOfAccount.do", method = RequestMethod.GET)
	public ModelAndView logOutOfAccount(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("customer");
		mv.setViewName("homePage");
		
		return mv;
	}

}
