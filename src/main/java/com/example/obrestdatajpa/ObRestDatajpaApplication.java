package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.entities.User;
import com.example.obrestdatajpa.repository.BookRepository;
import com.example.obrestdatajpa.repository.UserRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
		BookRepository repository = context.getBean(BookRepository.class);

		User user = new User(null,
				"usuario",
				encoder.encode("contraseña"),
				"USER");
		userRepository.save(user);

		User user2 = new User(null, "marco", encoder.encode("admin"), "USER");
		userRepository.save(user2);

		//CRUD

		//CREAR UN BOOK
		Book book1 = new Book(
				null,
				"La locura",
				"Mauricio Pedraza",
				100, 99.9,
				LocalDate.of(1989, 2, 26),
				true);
		repository.save(book1);

		//ALMACENAR UN BOOK
		Book book2 = new Book(
				null,
				"Homo deus",
				"Yuval Noah",
				450, 29.99,
				LocalDate.of(2013, 5, 10),
				true);

		repository.save(book2);

		//RECUPERAR TODOS LOS LIBROS ALMACENADOS
		Iterable<Book> books = repository.findAll();
		for (Book book : books) {
            System.out.println("Autor del libro: " + book.getAuthor()+" - " +"Título de la obra: "+book.getTitle());
        }

		System.out.println("La cantida de libros almacenados actualmente en el repo son: " + repository.findAll().size());

        //MODIFICAR UN BOOK



        //ELIMINAR UN BOOK
		//System.out.println("Se ha borrado 1 libro");
		//repository.deleteById(1L);

        //RECUPERAR TODOS LOS LIBROS ALMACENADOS
        System.out.println("La cantidad de libros almacenados actualmente en el repo son: " + repository.findAll().size());



		}


	}


