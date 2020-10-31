package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.Address;

public interface AddressDAO {

	Address getAddressById(int id);
	List <Address> listAllAddresses();
	Address createAddress(Address address);
	Address updateAddress(int id, Address address);
	boolean deleteAddress(int id);
	
	
}
