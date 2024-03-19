package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;

import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
VIDEO 5 RST CON SPRING
	- Controlador que es la clase que gestiona peticiones HTTP

 */
@RestController
public class BookController {
    /*
        - Método que devuelve una lista de libros
     */

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    //atributos
    private BookRepository bookrepository;

    //constructor

    public BookController(BookRepository bookrepository) {
        this.bookrepository = bookrepository;
    }


    //CRUD sobre la entidad Book

    //Método para buscar todos los libros (Lista ArrayList de libros)
    /*
     * GET http://localhost/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll() {
        //recuperar y devolver los libros de la base de datos
        return bookrepository.findAll();
    }

    //Devolver un solo libro de la base de datos según su ID
    /*
     * GET http://localhost/api/books/{id}
     * @return
     */
    //Video 7
    @GetMapping("/api/books/{id}")
    @Operation(summary = "Obtener un libro por clave primaria",
            description = "Devuelve un libro de todos los libros en la base de datos")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        //recuperar y devolver el libro de la base de datos según su ID

        //return bookrepository.findById(id).get();

        Optional<Book> bookOpt = bookrepository.findById(id);
        //Opción 1 de forma tradicional
        if(bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();

        //Opción 2 de forma optimizada y recomendada:

        //return bookOpt.orElse(null);
        //return bookOpt.map(ResponseEntity::ok).orElse(null);
        //return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    //Crear un nuebo libro en la base de datos
    @PostMapping("api/books")
    @Operation(summary = "Obtener todos los libros",
            description = "Devuelve una lista de todos los libros en la base de datos")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        //guardar el libro recibido por el parámetro en la base de datos
        System.out.println(headers.get("User-Agent"));
        if(book.getId() != null){ // qUIERE DECIR QUE EXISTE EL ID Y POR LO TANTO NO ES UNA CREACIÓN
            log.warn("Trying to create a book with id");
            System.out.println("Trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookrepository.save(book);
        return ResponseEntity.ok(result);  //el libro devuelto tiene una clave primaria que se le genera
    }

    //VIDEO 9 DEVOLVIENDO RESPUESTAS
    //Actualizar un libro de la base de datos
    @PutMapping("api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        //actualizar el libro recibido por el parámetro en la base de datos
        if(book.getId()== null) {
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();

        }
        //El proceso de actualización
        if(!bookrepository.existsById(book.getId())) {
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();

        }
        Book result = bookrepository.save(book);
        return ResponseEntity.ok(result);  //el libro devuelto tiene una clave primaria


    }

    //Método borrar un libro de la base de datos
    @DeleteMapping("api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        //borrar el libro recibido por el parámetro en la base de datos
        if(id== null) {
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.badRequest().build();

        }
        //El proceso de borrado
        if(!bookrepository.existsById(id)) {
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();

        }
        bookrepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Borrar todos los libros de la base de datos
    @DeleteMapping("api/books")
    public ResponseEntity<Book> deleteAll(){
        //borrar todos los libros de la base de datos
        if(bookrepository.count()>0) {
            bookrepository.deleteAll();
            return ResponseEntity.noContent().build();
        }
        log.info("REST request to delete all");
        log.warn("Trying to delete a empty list");
        return ResponseEntity.noContent().build();
    }




}
