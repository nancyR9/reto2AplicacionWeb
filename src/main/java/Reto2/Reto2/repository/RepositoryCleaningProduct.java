/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2.Reto2.repository;

import Reto2.Reto2.interfaces.InterfaceCleaningProduct;
import Reto2.Reto2.modelo.CleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ncp19
 */
@Repository
public class RepositoryCleaningProduct {
    @Autowired
    private InterfaceCleaningProduct repository;

    public List<CleaningProduct> getAll() {
        return repository.findAll();
    }

    public Optional<CleaningProduct> getCleanP(int id) {
        return repository.findById(id);
    }
    public CleaningProduct create(CleaningProduct cleanp) {
        return repository.save(cleanp);
    }

    public void update(CleaningProduct cleanpr) {
        repository.save(cleanpr);
    }
    
    public void delete(CleaningProduct cleanpro) {
        repository.delete(cleanpro);
    }
}
