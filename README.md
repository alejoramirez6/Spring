## Spring Boot

Starters para persistencia:
- h2: Una base de datos en memoria que se utiliza comúnmente para pruebas y desarrollo.

- spring-boot-starter-data-jpa: Proporciona las dependencias 
necesarias para trabajar con JPA en una aplicación Spring 
Boot.

Starters para web:

- spring-boot-starter-web: Proporciona las dependencias necesarias para desarrollar aplicaciones web utilizando Spring MVC.

- spring-boot-devtools: Proporciona herramientas de desarrollo adicionales para facilitar el desarrollo de aplicaciones Spring Boot, como la recarga automática de la aplicación cuando se realizan cambios en el código fuente.

- spring-boot-starter-test: Proporciona las dependencias necesarias para escribir pruebas unitarias y de integración en una aplicación Spring Boot.


Aplicación API REST con acceso a base de datos HE para persistir la información

El acceso se puede realizar desde Postman o Navegador.

##Entidad Book

1. Crear la clase book
2. Crear el BookRepository
3. Crear el BookController
   1. Buscar todos los libros
   2. Buscar un solo libro
   3. Crear un nuevo libro
   4. Actualizar un libro existente
   5. Borrar un libro
   6. Borrar todos los libros