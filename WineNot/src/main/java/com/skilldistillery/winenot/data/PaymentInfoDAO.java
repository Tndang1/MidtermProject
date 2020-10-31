package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.PaymentInfo;

public interface PaymentInfoDAO {
	
	PaymentInfo findById(int id);

	public PaymentInfo create(PaymentInfo payInfo);
	
	public PaymentInfo update(int id, PaymentInfo payInfo);
	
	public boolean deletePayInfo(int id);
	
	List<PaymentInfo> findAll();
	
	
}
