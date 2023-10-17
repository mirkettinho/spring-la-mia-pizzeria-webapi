package org.java.app.pizzeria.controller;



import java.util.List;

import org.java.app.pizzeria.pojo.Ingredienti;
import org.java.app.pizzeria.pojo.Offerte;
import org.java.app.pizzeria.pojo.Pizza;
import org.java.app.pizzeria.serv.IngredienteServ;
import org.java.app.pizzeria.serv.OffertaServ;
import org.java.app.pizzeria.serv.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


@Controller
public class PizzaController {

	@Autowired
	private PizzaServ pizzaServ;
	
	@Autowired
	private IngredienteServ ingredienteServ;
	
	@Autowired
	private OffertaServ offertaServ;
	
	@GetMapping("/")
	public String getIndex(@RequestParam(required = false) String searchInput,	Model model) {
		
		
		List<Pizza> pizze = searchInput == null ? pizzaServ.findAll() : pizzaServ.findByName(searchInput);
		model.addAttribute("pizze", pizze);
		model.addAttribute("searchInput", searchInput);
		
		return "pizze";
	}
	
	/// VISTA DETTAGLIO PIZZA
	@GetMapping("/pizza-details/{id}")
	public String getShow(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaServ.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza-show";
	}
	
	/// VISTA FORM CREAZIONE PIZZA
	@GetMapping("/pizza/create")
	public String getCreate(Model model) {
		
        
		model.addAttribute("pizza", new Pizza());
		
		return "pizza-create";
	}
	
	/// AGGIUNTA NUOVA PIZZA USANDO POST
	@PostMapping("/pizza/create")
	public String storeNewPizza(
		@Valid @ModelAttribute Pizza pizza,
		BindingResult br,
		Model model
	) {
		System.out.println("pizza:\n " + pizza);
		
		
		pizzaServ.save(pizza);
		
		return "redirect:/";
	}
	
	/// CONTROLLER UPDATE PIZZA
	@GetMapping("pizza/update/{id}")
	public String getUpdate(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaServ.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza-create";
	}
	
	/// MODIFICA DATI PIZZA RICEVUTI E AGGIORNATI
	@PostMapping("pizza/update/{id}")
	public String updatePizza(@Valid @ModelAttribute Pizza pizza,
			BindingResult bindingResult,
			Model model) {
		
			System.out.println("Modifica pizza\n" + pizza);
			
			
			return savePizza(pizza, bindingResult, model);
	}
	
	/// ELIMINAZIONE PIZZA
	@PostMapping("pizza/delete/{id}")
	public String deletePizza(@PathVariable int id) {
		
			Pizza pizza = pizzaServ.findById(id);
			
			List<Offerte> offerte = offertaServ.findByPizza(pizza);
		    for (Offerte offerta : offerte) {
		    	offertaServ.delete(offerta);
		    }
		    
			pizzaServ.deletePizza(pizza);
			
			return "redirect:/";
	}
	
	private String savePizza(Pizza pizza, BindingResult bindingResult, Model model) {
		
		pizzaServ.save(pizza);
		return "redirect:/";
		
	}
	
}
