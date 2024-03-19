package com.example.obrestdatajpa.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Books")
@Schema(description = "Entidad que representa un libro")
public class Book {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private Double price;
    //Localdate es una clase que viene del paquete java.time.LocalDate;
    private LocalDate releaseDate;
    private Boolean online;



    //Constructores

    public Book() {
    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate releaseDate, Boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.online = online;
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }


    //Métodos

    //tostring
}

/*
Este código define una clase Book que representa una entidad en una base de datos.
Aquí está la explicación detallada:

    @Entity: Esta anotación marca la clase como una entidad JPA, lo que significa
    que está asociada a una tabla en la base de datos. Cada instancia de esta clase
    representa una fila en la tabla Books.

    @Table(name="Books"): Esta anotación especifica el nombre de la tabla en la base
    de datos a la que está asociada la entidad Book. En este caso, la tabla se llamará
    "Books".

    Atributos:
        @Id: Esta anotación marca el atributo id como la clave primaria de la entidad.
        @GeneratedValue(strategy = GenerationType.IDENTITY): Esta anotación indica que
        el valor del atributo id se generará automáticamente mediante una estrategia
        de identidad de la base de datos.
        Los demás atributos (title, author, pages, price, releaseDate, online)
        representan las columnas de la tabla Books.

    Constructores:
        Se definen dos constructores, uno vacío y otro que acepta todos los atributos
        de la clase. El segundo constructor se utiliza para crear instancias de Book
        con valores específicos.

    Getters and Setters:
        Se definen los métodos get y set para todos los atributos de la clase, lo que
        permite acceder y modificar los valores de los atributos.

En resumen, esta clase Book representa una entidad en una base de datos con atributos
como título, autor, número de páginas, precio, fecha de lanzamiento y disponibilidad en
línea. Se utiliza en conjunto con BookRepository para realizar operaciones CRUD en la
tabla Books.
 */
