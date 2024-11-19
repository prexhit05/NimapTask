# E-Commerce API with Category and Product Management  

This project is a **Spring Boot-based REST API** that provides CRUD operations for managing categories and products in an e-commerce system. It demonstrates the use of **JPA**, **Hibernate**, **RESTful services**, and **server-side pagination**, with a focus on clean, annotation-based configuration.

---

## Features  

### Category Management  
- Create, Read, Update, and Delete (CRUD) operations for categories.  
- Fetch all categories with server-side pagination.  

### Product Management  
- CRUD operations for products.  
- Fetch all products with server-side pagination.  
- Retrieve single product details along with its associated category.  

### One-to-Many Relationship  
- One category can have multiple associated products.  

### Server-Side Pagination  
- Efficient pagination for both categories and products.  

---

## Tech Stack  

- **Backend:** Spring Boot (REST API), Spring Data JPA, Hibernate  
- **Database:** MySQL (or any RDBMS of your choice)  
- **Configuration:** Java-based annotations (no XML)  

---

## Endpoints  

### Category APIs  
1. `GET /api/categories?page={pageNumber}`  
   - Fetch all categories with pagination.  

2. `POST /api/categories`  
   - Create a new category.  

3. `GET /api/categories/{id}`  
   - Fetch a category by ID.  

4. `PUT /api/categories/{id}`  
   - Update a category by ID.  

5. `DELETE /api/categories/{id}`  
   - Delete a category by ID.  

### Product APIs  
1. `GET /api/products?page={pageNumber}`  
   - Fetch all products with pagination.  

2. `POST /api/products`  
   - Create a new product.  

3. `GET /api/products/{id}`  
   - Fetch a product by ID (includes associated category details).  

4. `PUT /api/products/{id}`  
   - Update a product by ID.  

5. `DELETE /api/products/{id}`  
   - Delete a product by ID.  

---

## Database Configuration  

1. Set up a relational database (e.g., MySQL).  
2. Configure the `application.properties` file:  

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

**Use Case:**
This project is ideal for understanding the implementation of RESTful APIs with relational database management and hierarchical entity relationships in an e-commerce system. It serves as a foundation for larger systems with complex relationships and data handling requirements.

**Contributions:**
Contributions are welcome! Please create a pull request or open an issue to improve the project.
