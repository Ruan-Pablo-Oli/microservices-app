package com.microservices.order.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="orders")
public class Order implements Serializable{
	
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	
	private String description;
	
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ItemOrder> itens;
	
	public Order() {
		
	}
	
	
	public Order(String description) {
		super();
		this.description = description;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ItemOrder> getItens() {
		return itens;
	}

	public void setItens(List<ItemOrder> itens) {
		this.itens = itens;
	}
	
	
	
	
}
