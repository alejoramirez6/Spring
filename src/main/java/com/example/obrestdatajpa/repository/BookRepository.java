package com.example.obrestdatajpa.repository;

import com.example.obrestdatajpa.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//el jparepository es el que nos va a heredar los métodos CRUD
//Ponemos Book que es la clase el tipo de dato y Long que es la clave primaria
//JpaRepository proporciona métodos como save, findAll, findById, delete, entre
// otros, para interactuar con la base de datos asociada a la entidad Book.
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
}


/*
  Este fragmento de código define una interfaz BookRepository que extiende
    JpaRepository<Book, Long>. Aquí hay una explicación detallada:

    @Repository: Esta anotación marca la interfaz como un bean de repositorio
    de Spring, lo que le indica a Spring que esta interfaz debe ser escaneada
    en busca de beans y que debe gestionar las excepciones de acceso a datos
    específicas de Spring.

    interface BookRepository extends JpaRepository<Book, Long>: Esta declaración
    de interfaz extiende JpaRepository<Book, Long>, lo que significa que BookRepository
    hereda métodos para realizar operaciones CRUD (Create, Read, Update, Delete) en la
    entidad Book.
        Book es el tipo de entidad que gestionará este repositorio.
        Long es el tipo de datos de la clave primaria de la entidad Book.

    JpaRepository proporciona métodos como save, findAll, findById, delete, entre otros,
    para interactuar con la base de datos asociada a la entidad Book.

    En resumen, esta interfaz BookRepository define un contrato para acceder a los datos
    de la entidad Book utilizando Spring Data JPA, lo que facilita la escritura de consultas
    y operaciones CRUD sin tener que implementarlas manualmente.
 */


//

/*
    Inyección de Dependencias en Spring: En Spring, la inyección de dependencias es un
    patrón de diseño en el que un objeto recibe las dependencias que necesita de una
    fuente externa en lugar de crearlas directamente. Esto ayuda a desacoplar los
    componentes de una aplicación y facilita la prueba y mantenimiento del código.

    @Repository y Gestión de Beans: La anotación @Repository en Spring se utiliza para
    marcar una clase como un bean de repositorio, que generalmente se utiliza para
    interactuar con una base de datos u otra fuente de datos. Cuando una clase está
    marcada con @Repository, Spring la considera un candidato para la inyección de
    dependencias y la gestiona como un bean en el contenedor de Spring.

    context.getBean(BookRepository.class): En el fragmento de código que proporcionaste,
    context.getBean(BookRepository.class) se utiliza para obtener una instancia de
    BookRepository del contenedor de Spring. Esta instancia se crea y se gestiona por
    Spring y se puede utilizar para interactuar con la base de datos de forma segura y
    eficiente.

En resumen, la anotación @Repository en la interfaz BookRepository indica a Spring que
esta interfaz debe ser tratada como un bean y gestionada por el contenedor de Spring.
Luego, al llamar a context.getBean(BookRepository.class), se obtiene una instancia de
BookRepository que puede ser utilizada en la aplicación para realizar operaciones en la
base de datos de manera transparente para el desarrollador.

 */
