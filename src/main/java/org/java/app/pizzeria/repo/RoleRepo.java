package org.java.app.pizzeria.repo;

import org.java.app.pizzeria.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{
	
}
