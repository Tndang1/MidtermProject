package com.skilldistillery.winenot.data;

import com.skilldistillery.winenot.entities.Address;
import com.skilldistillery.winenot.entities.Customer;

public interface AddressDAO3 {
	public Address create(Address address);
	public Address update(int id, Address address);
	public boolean destroy(int id);
	public Address createAddressAndCustomer(Address address, Customer customer);
	public Address findAddressById(int addressId);
	

}









//public Actor findActorById(int actorId) {
//	  Actor actor = null;
//	  //...
//	  String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
//	  PreparedStatement stmt = conn.prepareStatement(sql);
//	  stmt.setInt(1,actorId);
//	  ResultSet actorResult = stmt.executeQuery();
//	  if (actorResult.next()) {
//	    actor = new Actor(); // Create the object
//	    // Here is our mapping of query columns to our object fields:
//	    actor.setId(actorResult.getInt(1));
//	    actor.setFirstName(actorResult.getString(2));
//	    actor.setLastName(actorResult.getString(3));
//	  }
//	  //...
//	  return actor;
//	}



//public interface ActorDAO {
//	public Actor create(Actor actor);
//	public Actor update(int id, Actor actor);
//	public boolean destroy(int id);
//	public Actor createActorAndFilm(Actor actor, Film film);
//}







//CRUD
//Operations that Create, Retrieve, Update, and Destroy application data items. CRUD is not limited to database records.
//
//One direct approach to Java ORM includes writing DAO implementation code that uses JDBC query results to assemble application 
//objects, and to store an object use its fields as values in appropriate SQL INSERT, UPDATE, and DELETE statements.