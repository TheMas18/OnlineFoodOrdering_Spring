package com.ofd.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private User owner;

	private String name;
	
	private String description;
	
	private String cuisineType;
	
	@OneToOne
	private Address address;

	@Embedded
	private ContactInformation contactInformation;

	private String openingHours;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant" ,orphanRemoval = true)
	private List<Order> orders=new ArrayList<Order>();
	
	@ElementCollection
	@Column(length = 1000)
	private List<String> images;
	
	private LocalDateTime registrationDate;
	
	private boolean open;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant" ,cascade = CascadeType.ALL)
	private  List<Food> foods=new ArrayList<>();
	
	
	
	

}
