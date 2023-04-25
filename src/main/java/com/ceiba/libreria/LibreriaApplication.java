package com.ceiba.libreria;

import com.ceiba.libreria.bean.MyBeanWithProperties;
import com.ceiba.libreria.component.ComponentDependency;
import com.ceiba.libreria.entity.User;
import com.ceiba.libreria.pojo.UserPojo;
import com.ceiba.libreria.repository.UserRepository;
import com.ceiba.libreria.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class LibreriaApplication implements CommandLineRunner {

	@Autowired
	private ComponentDependency component;

	@Autowired
	private MyBeanWithProperties myBeanWithProperties;

	@Autowired
	private UserPojo userPojo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		log.error("inicio del procso run");
		//ejecuta en la aplicacion  lo que queramos
		component.saludar();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getMail() + userPojo.getPassword());
		log.error("fin del procso run");
		saveUsers();
		//findAllUsers();
		//findUserById(Long.valueOf(1));
		saveWithError();
	}

	private void saveUsers(){
		User user1 = new User();
		user1.setBirthDate(LocalDate.of(2002, 01, 01));
		user1.setMail("mail@ailll");
		user1.setName("JUANA");

		User user2 = new User();
		user2.setBirthDate(LocalDate.of(2005, 01, 01));
		user2.setMail("ma24@ailll");
		user2.setName("JUANA");
		userRepository.save(user1);
		userRepository.save(user2);
	}

	private void findUserById(Long id){

		List<User> users = userRepository.findAll();
		users.forEach(u -> System.out.println(u.toString()));

		log.info("usuario encontrado: " + userRepository.findByUserId(id).orElseThrow(() ->
				new RuntimeException("No se  encontro el usuario")));

		userRepository.findByName("JUANA").forEach(u ->
				log.info("user: " + u));

		log.info("user optional: " + userRepository.findByNameAndMail("JUANA", "ma24@ailll").orElseThrow(() ->
				new RuntimeException("eeror")));

		log.info("user DTO: " + userRepository.findByMailAndDate(
				LocalDate.of(2005, 01, 01), "ma24@ailll").orElseThrow(() ->
						new RuntimeException("Error al consultar la persona")));
	}

	private void saveWithError(){
		User test1 = new User(1L, "TestTransactional1", "TestTransactional1@domain.com", LocalDate.now(), null);
		User test2 = new User(2L, "TestTransactional2", "TestTransactional2@domain.com", LocalDate.now(), null);
		User test3 = new User(3L, "TestTransactional3", "TestTransactional3@domain.com", LocalDate.now(), null);
		User test4 = new User(1L, "TestTransactional4", "TestTransactional4@domain.com", LocalDate.now(), null);

		List<User> users = Arrays.asList(test1, test2, test3, test3);

		userService.saveInformation(users);
		userService.getAllusers().stream().forEach(u ->
				log.info("user insertado: " + u));
	}

}
