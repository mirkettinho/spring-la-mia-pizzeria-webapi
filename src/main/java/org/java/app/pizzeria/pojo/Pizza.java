package org.java.app.pizzeria.pojo;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "pizze")
public class Pizza {
	
	///PIZZA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	@Length(min = 3, max = 20)
	private String name;
	
	@Length(max = 255)
	private String description;
	
	@Length(max = 255)
	private String photo;
	
	@Min(0)
	@Max(100)
	private int price;
	
	@OneToMany(mappedBy = "pizza")
	private List<Offerte> offerte;
	
	@ManyToMany
	private List<Ingredienti> ingredienti;
	///PIZZA
	
	public Pizza() {}
	
	public Pizza(String name, String description, String photo, int price) {
		
		setName(name);
		setDescription(description);
		setPhoto(photo);
		setPrice(price);
	}
	
	
	/// get and set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public List<Offerte> getOfferta() {
		
		return offerte;
	}
	
	public void setOfferta(List<Offerte> offerte) {
		
		this.offerte = offerte;
	}
	
	public List<Ingredienti> getIngrediente() {
		
		return ingredienti;
	}
	
	public void setIngrediente(List<Ingredienti> ingredienti) {
		
		this.ingredienti = ingredienti;
	}
	
	
	@Override
	public String toString() {
		
		return "[" + getId() + "]" + getName() + " " + getDescription()+ " " + getPhoto() + " " + getPrice();
	}
}
