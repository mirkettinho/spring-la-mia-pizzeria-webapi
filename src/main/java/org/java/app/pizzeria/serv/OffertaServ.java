package org.java.app.pizzeria.serv;



import java.util.List;

import org.java.app.pizzeria.pojo.Offerte;
import org.java.app.pizzeria.pojo.Pizza;
import org.java.app.pizzeria.repo.OfferteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffertaServ {
	
	@Autowired
	private OfferteRepo offerteRepo;
	
	public void save(Offerte offerta) {
		
		offerteRepo.save(offerta);
	}
	
	public List<Offerte> findAll() {
		
		return offerteRepo.findAll();
	}
	
	public Offerte findById(Integer id) {
		
		return offerteRepo.findById(id).get();
	}
	
	public void delete(Offerte offerte) {
		
		offerteRepo.delete(offerte);
	}
	
	public List<Offerte> findByPizza(Pizza pizza) {
		
		return offerteRepo.findByPizza(pizza);
	}
}
