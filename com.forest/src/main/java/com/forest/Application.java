package com.forest;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.forest.model.Admin;
import com.forest.model.User;
import com.forest.repository.AdminRepository;
import com.forest.repository.UserRepository;



@SpringBootApplication
public class Application {
	@Autowired
	AdminRepository adminrepo;
	@Autowired
	UserRepository userrep;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	InitializingBean sendDatabase1()
	{
		return ()->
		{
			adminrepo.save(new Admin("janani","karthikA123"));
			adminrepo.save(new Admin("Hamsi","hamSI123"));
			adminrepo.save(new Admin("Vishnu","vishNU123"));
			adminrepo.save(new Admin("atchaya","atchaYA123"));
		};
	}

	@Bean
	InitializingBean sendDatabase2() {
		return () -> {
			userrep.save(new User("janani","karthikA123","cutomer"));
			userrep.save(new User("Hamsi","hamSI123","admin"));
			userrep.save(new User("Vishnu","vishNU123","admin"));
			userrep.save(new User("atchaya","atchaYA123","customer"));
		};
	}
	

}
