package org.java.app.pizzeria.serv;

import java.util.List;

import org.java.app.pizzeria.pojo.Role;
import org.java.app.pizzeria.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServ {
	
	@Autowired
	private RoleRepo roleRepo;
	
	public List<Role> findAll(){
		
		return roleRepo.findAll();
	}
	
	public Role findById(Integer id) {
		
		return roleRepo.findById(id).get();
	}
	
	public void save(Role role) {
		
		roleRepo.save(role);
	}
}
