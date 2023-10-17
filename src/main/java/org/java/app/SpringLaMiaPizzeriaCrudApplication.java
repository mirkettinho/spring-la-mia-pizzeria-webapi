package org.java.app;



import java.time.LocalDate;

import org.java.app.pizzeria.pojo.Ingredienti;
import org.java.app.pizzeria.pojo.Offerte;
import org.java.app.pizzeria.pojo.Pizza;
import org.java.app.pizzeria.pojo.Role;
import org.java.app.pizzeria.pojo.User;
import org.java.app.pizzeria.serv.IngredienteServ;
import org.java.app.pizzeria.serv.OffertaServ;
import org.java.app.pizzeria.serv.PizzaServ;
import org.java.app.pizzeria.serv.RoleServ;
import org.java.app.pizzeria.serv.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{

	@Autowired
	private PizzaServ pizzaServ;
	
	@Autowired
	private OffertaServ offertaServ;
	
	@Autowired
	private IngredienteServ ingredienteServ;
	
	@Autowired
	private RoleServ roleServ;
	
	@Autowired
	private UserServ userServ;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		/// PIZZA
		Pizza pizza1 = new Pizza("Margherita", "descrizione", "https://images.prismic.io/eataly-us/ed3fcec7-7994-426d-a5e4-a24be5a95afd_pizza-recipe-main.jpg?auto=compress,format", 5);
		Pizza pizza2 = new Pizza("Margherita2", "descrizione", "https://images.prismic.io/eataly-us/ed3fcec7-7994-426d-a5e4-a24be5a95afd_pizza-recipe-main.jpg?auto=compress,format", 5);
		Pizza pizza3 = new Pizza("Margherita3", "descrizione", "https://images.prismic.io/eataly-us/ed3fcec7-7994-426d-a5e4-a24be5a95afd_pizza-recipe-main.jpg?auto=compress,format", 5);
		
		pizzaServ.save(pizza1);
		pizzaServ.save(pizza2);
		pizzaServ.save(pizza3);
		
		/// OFFERTA
		Offerte offerta1 = new Offerte("-1%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza1 );
		Offerte offerta2 = new Offerte("-2%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza1 );
		Offerte offerta3 = new Offerte("-3%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza2 );
		Offerte offerta4 = new Offerte("-4%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza2 );
		Offerte offerta5 = new Offerte("-5%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza3 );
		Offerte offerta6 = new Offerte("-5%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza3 );
		
		offertaServ.save(offerta1 );
		offertaServ.save(offerta2 );
		offertaServ.save(offerta3 );
		offertaServ.save(offerta4 );
		offertaServ.save(offerta5 );
		offertaServ.save(offerta6 );
		
		/// INGREDIENTE	
		Ingredienti ingrediente1 = new Ingredienti("Mozzarella");
		
		ingredienteServ.save(ingrediente1 );
		
		
		
		/// RUOLI
		Role admin = new Role("admin");
		Role user = new Role("user");
		
		roleServ.save(admin);
		roleServ.save(user);
		
		final String pwdAdmin = new BCryptPasswordEncoder().encode("pwd");
		final String pwdUser = new BCryptPasswordEncoder().encode("pwd");
		
		User utenteAdmin = new User("provaAdmin", pwdAdmin, admin, user);
		User utenteBase = new User("provaBase", pwdUser, user);
		
		userServ.save(utenteAdmin);
		userServ.save(utenteBase);
		
		System.out.println("OK");
	}

}
