package com.skilldistillery.winenot.data;

import com.skilldistillery.winenot.entities.Payment;

public interface PaymentDAO {
	public Payment findById(int id);
	
	public Payment createPayment(Payment payment);
	public Payment updatePayment(int id, Payment payment);
	public void deletePayment(int id);

}
