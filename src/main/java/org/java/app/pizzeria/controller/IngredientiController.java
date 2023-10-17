package org.java.app.pizzeria.controller;

import org.java.app.pizzeria.pojo.Ingredienti;
import org.java.app.pizzeria.repo.IngredientiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ingredienti")
public class IngredientiController {

	@Autowired
    private IngredientiRepo ingredientiRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("ingredientiList", ingredientiRepo.findAll());
        model.addAttribute("ingredienteObj", new Ingredienti());
        return "ingredienti/ingrediente-create";
    }

    
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("ingredienteObj") Ingredienti ingredienti, RedirectAttributes redirectAttributes) {
        ingredientiRepo.save(ingredienti);
        redirectAttributes.addFlashAttribute("message", "Ingrediente aggiunto con successo!");

        return "redirect:/ingredienti";
    }

    
    @PostMapping("/delete/{ingId}")
    public String delete(@PathVariable("ingId") Integer id) {
        ingredientiRepo.deleteById(id);
        return "redirect:/ingredienti";
    }
}
