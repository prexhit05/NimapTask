package com.nimapInfotech.task.services;

import com.nimapInfotech.task.entities.Catagory;
import com.nimapInfotech.task.entities.Product;
import com.nimapInfotech.task.exception.CatagoryNotFoundException;
import com.nimapInfotech.task.exception.ResourceNotFoundException;
import com.nimapInfotech.task.repositories.CatagoryRepo;
import com.nimapInfotech.task.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CatagoryRepo catagoryRepo;

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    public Product saveProduct(Product product) {
        Catagory catagory = catagoryRepo.findByCatagoryName(product.getCatagory().getCatagoryName()).orElseThrow(CatagoryNotFoundException::new);
        product.setCatagory(catagory);
        catagory.getProductList().add(product);
        Product save = productRepo.save(product);
        return product;
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Product updateProduct(int id, Product product) {
        Product productById = getProductById(id);
        productById.setPName(product.getPName() != null && !product.getPName().isEmpty() ? product.getPName() : productById.getPName());
        productById.setPrice(product.getPrice() != 0 ? product.getPrice() : productById.getPrice());
        productById.setDescription(product.getDescription() != null && !product.getDescription().isEmpty() ? product.getDescription() : productById.getDescription());
        Product save = productRepo.save(productById);
        return save;
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}
