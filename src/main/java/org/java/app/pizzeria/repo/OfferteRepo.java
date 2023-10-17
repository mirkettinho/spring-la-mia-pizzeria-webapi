package org.java.app.pizzeria.repo;

import java.util.List;

import org.java.app.pizzeria.pojo.Offerte;
import org.java.app.pizzeria.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferteRepo extends JpaRepository<Offerte, Integer> {

	public List<Offerte> findByPizza(Pizza pizza);
}
