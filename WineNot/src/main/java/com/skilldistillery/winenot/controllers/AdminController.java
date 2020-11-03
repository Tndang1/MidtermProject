package com.skilldistillery.winenot.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.winenot.data.AddressDAO;
import com.skilldistillery.winenot.data.CustomerDAO;
import com.skilldistillery.winenot.data.CustomerOrderDAO;
import com.skilldistillery.winenot.data.PaymentInfoDAO;
import com.skilldistillery.winenot.data.ReviewDAO;
import com.skilldistillery.winenot.data.UserDAO;
import com.skilldistillery.winenot.data.WineDAO;

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
	
	
	//Admin can delete reviews
	
	//Admin can disable wine
	
	//Admin can disable user
}
