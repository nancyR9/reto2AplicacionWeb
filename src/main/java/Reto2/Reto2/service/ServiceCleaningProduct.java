/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2.Reto2.service;


import Reto2.Reto2.modelo.CleaningProduct;
import Reto2.Reto2.repository.RepositoryCleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ncp19
 */
@Service
public class ServiceCleaningProduct {
    
    @Autowired
     private RepositoryCleaningProduct CleanProdRepository ;
    
     public List<CleaningProduct> getAll(){
        return CleanProdRepository.getAll();
    }
    
    public Optional <CleaningProduct> getCleanProd(Integer id){
        return CleanProdRepository.getCleanP(id);
    }
    
    public CleaningProduct create (CleaningProduct cleaningProduct){
        if(cleaningProduct.getId()==null){
            return cleaningProduct;
        }else{
           return CleanProdRepository.create(cleaningProduct);
        }
    }
    
    public CleaningProduct update(CleaningProduct accesory) {
        if (accesory.getId() != null) {
            Optional<CleaningProduct> accesoryDb = CleanProdRepository.getCleanP(accesory.getId());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                if (accesory.getPresentation() != null) {
                    accesoryDb.get().setPresentation(accesory.getPresentation());
                }
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                CleanProdRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }
    
       public boolean delete(int cleanProdId){
         Boolean aBoolean= getCleanProd(cleanProdId).map(cleanProduct ->{
            CleanProdRepository.delete(cleanProduct);
            return true;
         }).orElse(false);
         return aBoolean;
    }
}
