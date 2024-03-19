package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {

        //Configuración de la prueba
        BookPriceCalculator calculator = new BookPriceCalculator();
        Book book = new Book(1L,
                "Señor de los anillos",
                "El autor del libro",
                500,
                100.0,
                LocalDate.now(),
                true);

        //se ejecuta el comportamiento a testear
        double price = calculator.calculatePrice(book);

        //comprobaciones - aserciones
        assertTrue(price>0);
        assertEquals(107.99, price);
    }
}