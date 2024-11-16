package com.nimapInfotech.task.services;

import com.nimapInfotech.task.entities.Catagory;
import com.nimapInfotech.task.exception.CatagoryNotFoundException;
import com.nimapInfotech.task.repositories.CatagoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class CatagoryService {
    @Autowired
    private CatagoryRepo catagoryRepo;

    public Page<Catagory> getAllCatagories(Pageable pageable){
        Page<Catagory> all = catagoryRepo.findAll(pageable);
        return all;
    }

    public Catagory save(Catagory catagory) {
        return catagoryRepo.save(catagory);
    }

    public Catagory findByid(int id) {
        return catagoryRepo.findById(id).orElseThrow(CatagoryNotFoundException::new);
    }

    public Catagory updateCatagory(int id, Catagory catagory) {
        Catagory byid = findByid(id);
        if (catagory.getCatagoryName() != null && !catagory.getCatagoryName().isEmpty()) {
            byid.setCatagoryName(catagory.getCatagoryName());
        }
        return catagoryRepo.save(byid);
    }

    public void deletebyid(int id) {
        if (findByid(id)!=null){
            catagoryRepo.deleteById(id);
        }
    }
}
