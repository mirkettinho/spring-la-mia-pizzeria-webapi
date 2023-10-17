package org.java.app.pizzeria.controller;



import java.time.LocalDate;
import java.util.Optional;

import org.java.app.pizzeria.pojo.Offerte;

import org.java.app.pizzeria.pojo.Pizza;
import org.java.app.pizzeria.repo.OfferteRepo;
import org.java.app.pizzeria.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/offerte")
public class OffertaController {

	@Autowired
	private OfferteRepo offerteRepo;
	
	@Autowired
	private PizzaRepo pizzaRepo;
	
	///AGGIUNGERE OFFERTA
	@GetMapping("/create")
	public String create(@RequestParam("pizzaId") Integer pizzaId, Model model) {
		
		Optional<Pizza> optionalPizza = pizzaRepo.findById(pizzaId);
			
		if (optionalPizza.isPresent()) {
			
			Pizza pizza = optionalPizza.get();
			Offerte offerta = new Offerte();
			offerta.setPizza(pizza);
			offerta.setDataInizio(LocalDate.now());
            offerta.setDataFine(LocalDate.now().plusDays(15));
			model.addAttribute("offerta", offerta);
			
			return "offerte/offerta-create";
			
		} else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza con id " + pizzaId + " non trovata");
        	}
		
		}
	
		/// RICEZIONE DATI NUOVA OFFERTA
		@PostMapping("/create")
		public String storeNewOfferta(@Valid @ModelAttribute("offerta") Offerte offerta, 
				BindingResult bindingResult) {
					
			offerteRepo.save(offerta);
			return "redirect:/pizza-details/" + offerta.getPizza().getId();
			
		}
		
		
		/// MODIFICA OFFERTA
	    @GetMapping("/edit/{offertaId}")
	    public String edit(@RequestParam("offertaId") Integer id, Model model) {
	        Optional<Offerte> risultatoOfferta = offerteRepo.findById(id);
	        if (risultatoOfferta.isPresent()) {
	            model.addAttribute("offerta", risultatoOfferta.get());
	            return "offerte/offerta-edit";

	        } else {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    /// MODIFICO E AGGIORNO DATI OFFERTA
	    @PostMapping("/edit/{offertaId}")
	    public String doEdit(@PathVariable("offertaId") Integer offertaId, @ModelAttribute("offerta") Offerte offertaForm) {
	        offertaForm.setId(offertaId);
	        offerteRepo.save(offertaForm);
	        return "redirect:/pizza-details/" + offertaForm.getPizza().getId();
	    }

	    /// ELIMINO OFFERTA
	    @PostMapping("/delete/{offertaId}")
	    public String delete(@PathVariable("offertaId") Integer id) {
	        Optional<Offerte> risultatoOfferta = offerteRepo.findById(id);
	        if (risultatoOfferta.isPresent()) {
	            Integer pizzaId = risultatoOfferta.get().getPizza().getId();
	            offerteRepo.deleteById(id);
	            return "redirect:/pizza-details/" + pizzaId;
	        } else {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        }
	    }
		
			
	
}
