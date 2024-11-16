package com.nimapInfotech.task.controllers;

import com.nimapInfotech.task.entities.Product;
import com.nimapInfotech.task.exception.ResourceNotFoundException;
import com.nimapInfotech.task.payload.ApiResponse;
import com.nimapInfotech.task.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // GET all the products -- http://localhost:8080/api/products?page=2

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Product>>> getAllProducts(Pageable pageable) {
        Page<Product> allProducts = productService.getAllProducts(pageable);
        if (allProducts.isEmpty()){
            throw new ResourceNotFoundException("Product List is empty on the SERVER");
        }
        ApiResponse<Page<Product>> response=new ApiResponse<>("All products",allProducts,true,HttpStatus.FOUND);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    // POST - create a new product -- http://localhost:8080/api/products

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> saveProduct(@RequestBody Product product) {
        ApiResponse<Product> response=new ApiResponse<Product>("Saved Successfully",productService.saveProduct(product),true,HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    // GET product by id -- http://localhost:8080/api/products/%7Bdi%7D

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable("id") int id) {
        Product productById = productService.getProductById(id);
        System.out.println(productById);
        ApiResponse<Product> response = new ApiResponse<>("Product by ID - "+id,productById,true,HttpStatus.FOUND);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    // PUT - update product by id -- http://localhost:8080/api/products/{di}

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {

        Product updated = productService.updateProduct(id, product);
        ApiResponse<Product> response=new ApiResponse<>("Product Updated | ID - "+id,updated,true,HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // DELETE - Delete product by id -- http://localhost:8080/api/products/{di}

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteProduct(@PathVariable("id") int id) {
        if (productService.getProductById(id)!=null){
            productService.deleteProduct(id);
        }else{
            throw new ResourceNotFoundException("Product not found on the SERVER with id"+id);
        }
        ApiResponse<?> response=new ApiResponse<>("Product Deleted for the Server | ID - "+id,HttpStatus.OK,true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
