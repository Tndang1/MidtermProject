package com.skilldistillery.winenot.controllers;

import java.time.LocalDateTime;
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
import com.skilldistillery.winenot.data.CustomerOrderDAO;
import com.skilldistillery.winenot.data.WineDAO;
import com.skilldistillery.winenot.entities.Address;
import com.skilldistillery.winenot.entities.Customer;
import com.skilldistillery.winenot.entities.CustomerOrder;
import com.skilldistillery.winenot.entities.PaymentInfo;
import com.skilldistillery.winenot.entities.Wine;

@Controller
public class CustomerOrderController {

	//*************Order DAO**********
	
	@Autowired
	private CustomerOrderDAO custOrderDAO;
	@Autowired
	private CustomerDAO custDAO;
	@Autowired
	private WineDAO wineDAO;
	
	
	//GUIDE for request mapping ===========================================================
	
	//Checkout page controllers start at line 49
	//ORDER LSIT Controllers start at line 82
	//Create order controllers start at line 110
	//Update order controllers start at line 150
	//CRUD for Order controllers start at line 178
	
	//Checkout page controllers ==============================================================
	
	@RequestMapping(path = "checkout.do", method = RequestMethod.GET)
	private String checkoutInfo(Model model) {
		//Integer customerId was in method
//		CustomerOrder customerOrder = custOrderDAO.findById(customerOrderId);
//		List<Wine> wines = customerOrder.getWines();
//		Customer customer = customerOrder.getCustomer();
//		Address address = customer.getAddress();
//		PaymentInfo paymentInfo = customer.getPaymentInfo();
//		Address billingAddress = paymentInfo.getAddress();
//		model.addAttribute("custOrder", customerOrder);
//		model.addAttribute("customer", customer);
//		model.addAttribute("customerAddress", address);
//		model.addAttribute("bilingAddress", billingAddress);
//		model.addAttribute("paymentInfo", paymentInfo);
//		model.addAttribute("wines", wines);
		return "checkout";
	}
	@RequestMapping(path = "removeWineFromCheckout.do", method = RequestMethod.GET)
	private String removeWineFromCheckout(Model model, Integer customerOrderId, Integer wineId) {
		CustomerOrder customerOrder = custOrderDAO.findById(customerOrderId);
		custOrderDAO.removeWineFromOrder(customerOrderId, wineId);
		Customer customer = customerOrder.getCustomer();
		Address address = customer.getAddress();
		List<Wine> wines = customerOrder.getWines();
		PaymentInfo paymentInfo = customer.getPaymentInfo();
		model.addAttribute("custOrder", customerOrder);
		model.addAttribute("customer", customer);
		model.addAttribute("customerAddress", address);
		model.addAttribute("paymentInfo", paymentInfo);
		model.addAttribute("wines", wines);
		return "checkout";
	}
	
	//ORDER LIST CONTROLLERS ===========================================================
	
	@RequestMapping(path = "findById.do", method = RequestMethod.GET)
	private String findOrdersById(Model model, int id) {
		CustomerOrder custOrderId = custOrderDAO.findById(id);
		model.addAttribute("custOrder", custOrderId);
		return "custOrderById";
	}

	//***************list of orders***************
	@RequestMapping(path = "orderList.do", method = RequestMethod.GET)
	public String listedOrders(Model model) {
		List<CustomerOrder> orderList = custOrderDAO.findAll();
		model.addAttribute("order", orderList);
		return "orderList";
	}
	//******************delete list of wines***************
	@RequestMapping(path = "removeAllWine", method = RequestMethod.GET)
	public String removeAllWinesFromOrder(Model model, int id) {
		CustomerOrder custOrderId = custOrderDAO.findById(id);
		List<Wine> wines = custOrderId.getWines();
		for (Wine wine : wines) {
			custOrderDAO.removeWineFromOrder(id, wine.getId());
			
		}
		return "allWineGone";
	}

	//CREATE ORDER CONTROLLERS ======================================================================================================================

	@RequestMapping(path = "create.do", method = RequestMethod.POST)
	public ModelAndView createCustomerOrder(HttpSession session, CustomerOrder order, Integer custId, 
			Integer wineColor, RedirectAttributes ra) {
		Customer customer = (Customer)session.getAttribute("customer");
  	customer.getAddress();
		customer.getPaymentInfo();
		if (order.getSize() == 12) {
			order.setAmount(220.99);
		}
		order.setCustomer(customer);
		List<Wine> wines = null;
		if (wineColor > 0 && wineColor < 3) {
		wines = wineDAO.findWineByWineColorId(wineColor);
		} else {
			wines = wineDAO.findAllEnabledWine();
		}
		Collections.shuffle(wines);
		for(int i = 0; i < order.getSize(); i++) {
			order.addWine(wines.get(i));
		}
		CustomerOrder addOrder = custOrderDAO.create(order);
		ModelAndView mv = new ModelAndView();
		ra.addFlashAttribute("addressInfo", customer.getAddress());
		ra.addFlashAttribute("paymentInfo", customer.getPaymentInfo());
		ra.addFlashAttribute("order", addOrder);
		mv.setViewName("redirect:orderMade.do");
		return mv;
	}


	@RequestMapping(path = "orderMade.do", method = RequestMethod.GET)
	public ModelAndView created() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmationPage"); 
		return mv;
	}

	// UPDATE ORDER CONTROLLERS ===========================================================

	@RequestMapping(path = "changeOrder.do")
	public ModelAndView updateOrder(int id, CustomerOrder order) {
		ModelAndView mv = new ModelAndView();
		CustomerOrder updateOrder = custOrderDAO.findById(id);
		mv.addObject("order", updateOrder);
		mv.setViewName("redirect:updatedOrder.do");
		return mv;
	}

	
	@RequestMapping(path = "updatedOrder.do", method = RequestMethod.POST)
	public ModelAndView update(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("order", custOrderDAO.findById(id));
		mv.setViewName("updateOrder");
		return mv;
	}

	
	@RequestMapping(path = "Updated.do", method = RequestMethod.POST)
	public ModelAndView updateConfirmation(int id, CustomerOrder order) {
		ModelAndView mv = new ModelAndView();
		custOrderDAO.update(id, order); // double check this
		mv.addObject("order", order);
		mv.setViewName("updatedOrderPage");
		return mv;
	}

	//	CRUD FOR ORDER CONTROLLERS  ================================================================
	
	@RequestMapping(path = "removeWineFromOrder.do", method = RequestMethod.GET)
	public ModelAndView showDeletedOrder(Integer id, int wineId) {
		custOrderDAO.removeWineFromOrder(id, wineId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteWineFromOrder");
		return mv;
	}

	@RequestMapping(path = "addWineToOrder.do", method = RequestMethod.GET)
	public ModelAndView showAddedOrder(Integer id, Wine wine) {
		custOrderDAO.addWineToOrder(id, wine);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("checkout");
		return mv;
	}
	
	@RequestMapping(path = "customerOrder.do", method = RequestMethod.POST)
	private String createOrder(Model model, Integer customerOrderId) {
		CustomerOrder customerOrder = custOrderDAO.findById(customerOrderId);
		List<Wine> wines = customerOrder.getWines();
		Customer customer = customerOrder.getCustomer();
		Address address = customer.getAddress();
		PaymentInfo paymentInfo = customer.getPaymentInfo();
		Address billingAddress = paymentInfo.getAddress();
		model.addAttribute("custOrder", customerOrder);
		model.addAttribute("customer", customer);
		model.addAttribute("customerAddress", address);
		model.addAttribute("bilingAddress", billingAddress);
		model.addAttribute("paymentInfo", paymentInfo);
		model.addAttribute("wines", wines);
		return "confirmationPage";
	}
}
