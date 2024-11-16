package com.nimapInfotech.task.controllers;

import com.nimapInfotech.task.entities.Catagory;
import com.nimapInfotech.task.exception.ResourceNotFoundException;
import com.nimapInfotech.task.payload.ApiResponse;
import com.nimapInfotech.task.services.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CatagoryController {
    @Autowired
    private CatagoryService catagoryService;

//GET all the categories -- http://localhost:8080/api/categories?page=3

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Catagory>>> catagories(Pageable pageable) {
        Page<Catagory> allCatagories = catagoryService.getAllCatagories(pageable);
        if (allCatagories.isEmpty()){
            throw new ResourceNotFoundException("Categories not found on the Server");
        }
        ApiResponse<Page<Catagory>> response =new ApiResponse<>("All Catagories",allCatagories,true,HttpStatus.FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


//POST - create a new category -- http://localhost:8080/api/categories

    @PostMapping
    public ResponseEntity<ApiResponse<Catagory>> createCatagory(@RequestBody Catagory catagory) {
        Catagory save = catagoryService.save(catagory);
        ApiResponse<Catagory> response =new ApiResponse<>("Saved Successfully ",save,true,HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//GET category by Id  -- http://localhost:8080/api/categories/%7Bdi%7D

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Catagory>> findById(@PathVariable("id") int id) {
        Catagory byid = catagoryService.findByid(id);
        ApiResponse<Catagory> response = new ApiResponse<>("Category with ID - "+id,byid,true,HttpStatus.FOUND);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

// PUT - update category by id  -- http://localhost:8080/api/categories/{di}

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Catagory>> updateCatagory(@PathVariable("id") int id, @RequestBody Catagory catagory) {
        Catagory updatedCatagory = catagoryService.updateCatagory(id, catagory);
        ApiResponse<Catagory> response =new ApiResponse<>("Successfully Updated Category with ID - "+id,updatedCatagory,true,HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


//DELETE - Delete category by id -- http://localhost:8080/api/categories/{di}


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCatagory(@PathVariable("id") int id){
        catagoryService.deletebyid(id);
        ApiResponse<?> response=new ApiResponse<>("Successfully Deleted | ID - "+id,HttpStatus.OK,true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}