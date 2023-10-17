package org.java.app.pizzeria.pojo;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredienti")
public class Ingredienti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeIngrediente;
		
	
	
	@ManyToMany(mappedBy = "ingredienti")
	@JsonBackReference
	
	private List<Pizza> pizza;
	public Ingredienti() {}
	
	public Ingredienti(String nomeIngredientea) {
			
		setNomeIngrediente(nomeIngrediente);
	}
		
	/// GET ¬ SET
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeIngrediente() {
		return nomeIngrediente;
	}

	public void setNomeIngrediente(String nomeIngrediente) {
		this.nomeIngrediente = nomeIngrediente;
	}
	
	
	
	
}
