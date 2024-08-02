package com.ofd.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long order_id;

	@ManyToOne
	private User customer;

	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;

	private long totalAmount;

	private String orderStatus;

	private Date createdAt;

	@ManyToOne
	private Address deliveryAddress;

	@OneToMany
	private List<OrderItem> items;

//	private Payment payments;

	private int totalItem;

	private int totalPrice;

}
