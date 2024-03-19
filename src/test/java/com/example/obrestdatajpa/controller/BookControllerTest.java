package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.*;

//en el caso de los controladores se pone webEnvironment para asignar o indicar un puerto
@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Comprobar hola mundo desde controlador sprint test")
    @Test
    void hello() {
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("/hola", String.class);
        assertEquals("Hola mundo que tal vamos el día de hoy de marzo ", response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

    }
    @Test
    void findAll() {
        ResponseEntity<Book[]> response =
                testRestTemplate.getForEntity("/api/books", Book[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //assertNotNull(response.getBody());
        assertThat(response.getStatusCodeValue(), is(200));
        assertEquals(200, response.getStatusCodeValue());

        List<Book> books = Arrays.asList(response.getBody());
        System.out.println(books.size());

        //assertEquals(200.0, response.getStatusCodeValue(), 0.001);
        //assertEquals(2, response.getBody().length);
       // assertEquals("Homo deus", response.getBody()[0].getTitle());
        //assertEquals("Yuval Noah", response.getBody()[1].getTitle());

    }

    @Test
    void findById() {
        ResponseEntity<Book> response =
                testRestTemplate.getForEntity("/api/books/1", Book.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {
        ResponseEntity<Book> response =
                testRestTemplate.postForEntity(
                        "/api/books",
                        new Book(null, "La locura",
                                "Mauricio Pedraza",
                                100,
                                99.9,
                                LocalDate.of(1989, 2, 26),
                                true), Book.class);
        Book result = response.getBody();
        System.out.println("HOLA SOY EL CÓDIGO ID DEL LIBRO: " + result.getId());
        assertEquals(1L, result.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}