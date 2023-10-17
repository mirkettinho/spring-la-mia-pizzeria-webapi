package org.java.app.pizzeria.serv;


import org.java.app.pizzeria.pojo.Ingredienti;
import org.java.app.pizzeria.repo.IngredientiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IngredienteServ {

	@Autowired
	private IngredientiRepo ingredientiRepo;

	public void save(Ingredienti ingrediente) {
		
		ingredientiRepo.save(ingrediente);
	}
}
