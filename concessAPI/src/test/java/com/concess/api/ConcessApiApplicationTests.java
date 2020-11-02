package com.concess.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.concess.api.entity.User;
import com.concess.api.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ConcessApiApplicationTests {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void contextLoads() {
		User us = new User();
		
		us.setUsername("admin");
		us.setName("Administrador");
		us.setPassword(encoder.encode("C0nc3551973#"));
		us.setEmail("admin@concess.com");
		us.setStatus(true);
		User retorno = repo.save(us);
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
