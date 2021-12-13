/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2.Reto2.controller;

import Reto2.Reto2.modelo.CleaningProduct;
import Reto2.Reto2.service.ServiceCleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ncp19
 */
@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin(origins = "*")
public class ControllerCleaningProduct {
    @Autowired
    private ServiceCleaningProduct cleanProdService;
    @GetMapping("/all")
    public List <CleaningProduct> getAll(){
        return cleanProdService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional <CleaningProduct> getCleanProd(@PathVariable("id") int id){
        return cleanProdService.getCleanProd(id);
    }
    
     @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct create(@RequestBody CleaningProduct cleanProd) {
        return cleanProdService.create(cleanProd);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct cleanProd) {
        return cleanProdService.update(cleanProd);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delate(@PathVariable("id") int cleanProd) {
        return cleanProdService.delete(cleanProd);
    }
   
}
