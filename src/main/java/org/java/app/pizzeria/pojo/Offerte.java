package org.java.app.pizzeria.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "offerte")
public class Offerte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	@Column(nullable = false)
	private String titolo;
	
	private LocalDate dataInizio;
	
	private LocalDate dataFine;
	
	@ManyToOne
	@JoinColumn(name = "pizza_id")
	private Pizza pizza;
	
	///OFFERTA
	
	public Offerte() {}
		
	public Offerte(String titolo, LocalDate dataInizio, LocalDate dataFine, Pizza pizza) {
			
		setTitolo(titolo);
		setDataInizio(dataInizio);
		setDataFine(dataFine);
		setPizza(pizza);
	}
		
	
	/// get and set
	
	///ID
	public Integer getId() {
		
		return id;
	}
	
	public void setId(Integer id) {
		
		this.id = id;
	}
	
	///TITOLO
	public String getTitolo() {
		
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		
		this.titolo = titolo;
	}
	
	///DATA INIZIO
	public LocalDate getDataInizio() {
		
		return dataInizio;
	}
	
	public void setDataInizio(LocalDate dataInizio) {
		
		this.dataInizio = dataInizio;
	}
	
	///DATA FINE
	public LocalDate getDataFine() {
		
		return dataFine;
	}
	
	public void setDataFine(LocalDate dataFine) {
		
		this.dataFine = dataFine;
	}
	
	///PIZZA
	
	public Pizza getPizza() {
		
		return pizza;
	}
	
	public void setPizza(Pizza pizza) {
		
		this.pizza = pizza;
	}
	
	
	@Override
	public String toString() {
		
		return getTitolo() + "data inizio: " + getDataInizio() + "data fine: " + getDataFine();
	}
	
}
