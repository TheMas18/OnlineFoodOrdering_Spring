package com.ofd.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofd.dto.RestaurantDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
	private String fullName;
	private String email;
	private String password;
	private USER_ROLE userRole;

	// why json ignore, its because whenever i fetch user that time i dont want this
	// list of the order
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Order> orders = new ArrayList<>();

	@ElementCollection
	private List<RestaurantDto> favorites = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true)
	private List<Address>addresses=new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
