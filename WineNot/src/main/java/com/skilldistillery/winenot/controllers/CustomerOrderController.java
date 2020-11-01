package com.skilldistillery.winenot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.winenot.data.CustomerOrderDAO;
import com.skilldistillery.winenot.entities.CustomerOrder;
import com.skilldistillery.winenot.entities.Wine;

public class CustomerOrderController {

//	Order DAO==============================================
	@Autowired
	private CustomerOrderDAO custOrderDAO;

//  Return to home page ======================================================
	
	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}
	
//	Find orders by id=====================================================
	@RequestMapping(path = "findById.do", method = RequestMethod.GET)
	private String findOrdersById(Model model, int id) {
		CustomerOrder custOrderId = custOrderDAO.findById(id);
		model.addAttribute("custOrder", custOrderId);
		return "custOrderById";
	}
	

//	list of orders=======================================================
	@RequestMapping(path = "orderList.do", method = RequestMethod.GET)
	public String listedOrders(Model model) {
		List<CustomerOrder> orderList = custOrderDAO.findAll();
		model.addAttribute("order", orderList);
		return "orderList";
	}
//	delete list of wines================================================
	@RequestMapping(path = "removeAllWine", method = RequestMethod.GET)
	public String removeAllWinesFromOrder(Model model, int id) {
		CustomerOrder custOrderId = custOrderDAO.findById(id);
		List<Wine> wines = custOrderId.getWines();
		for (Wine wine : wines) {
			custOrderDAO.removeWineFromOrder(id, wine);
			
		}
		return "allWineGone";
	}

	
	

//  Create Order==============================================================

	@RequestMapping(path = "create.do", method = RequestMethod.POST)
	public ModelAndView createCustomerOrder(CustomerOrder order, RedirectAttributes ra) {
		CustomerOrder addOrder = custOrderDAO.create(order);

		ModelAndView mv = new ModelAndView();
		ra.addFlashAttribute("order", addOrder);
		mv.setViewName("redirect:orderMade.do");

		return mv;
	}

	// new order added=============================================================
	@RequestMapping(path = "orderMade.do", method = RequestMethod.GET)
	public ModelAndView created() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showOrder"); 
		return mv;
	}

//	update order ===========================================================

	@RequestMapping(path = "changeOrder.do")
	public ModelAndView updateOrder(int id, CustomerOrder order) {
		ModelAndView mv = new ModelAndView();
		CustomerOrder updateOrder = custOrderDAO.findById(id);
		mv.addObject("order", updateOrder);
		mv.setViewName("redirect:updatedOrder.do");
		return mv;
	}

//	updated by redirect====================================================
	@RequestMapping(path = "updatedOrder.do", method = RequestMethod.POST)
	public ModelAndView update(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("order", custOrderDAO.findById(id));
		mv.setViewName("updateOrder");
		return mv;

	}

//	display updated order=================================================
	@RequestMapping(path = "Updated.do", method = RequestMethod.POST)
	public ModelAndView updateConfirmation(int id, CustomerOrder order) {
		ModelAndView mv = new ModelAndView();
		custOrderDAO.update(id, order); // double check this
		mv.addObject("order", order);
		mv.setViewName("updatedOrderPage");
		return mv;

	}

//	delete wineFromOrder ================================================================
	@RequestMapping(path = "removeWineFromOrder.do", method = RequestMethod.GET)
	public ModelAndView showDeletedOrder(Integer id, Wine wine) {
		custOrderDAO.removeWineFromOrder(id, wine);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteWineFromOrder");
		return mv;
	}
//	add wineFromOrder ================================================================
	@RequestMapping(path = "addWineToOrder.do", method = RequestMethod.GET)
	public ModelAndView showAddedOrder(Integer id, Wine wine) {
		custOrderDAO.addWineToOrder(id, wine);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addWineFromOrder");
		return mv;
	}

}
