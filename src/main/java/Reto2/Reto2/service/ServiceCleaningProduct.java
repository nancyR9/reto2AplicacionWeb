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
        return CleanProdRepository.getCleanProd(id);
    }
    
    public CleaningProduct create (CleaningProduct cleaningProduct){
        if(cleaningProduct.getId()==null){
            return cleaningProduct;
        }else{
           return CleanProdRepository.create(cleaningProduct);
        }
    }
    
    public CleaningProduct update(CleaningProduct cleanProduct) {
        if (cleanProduct.getId() == null) {
            Optional<CleaningProduct> userDb = CleanProdRepository.getCleanProd(cleanProduct.getId());
            
            if (!userDb.isEmpty()) {
                if(cleanProduct.getBrand() !=null){
                    userDb.get().setBrand(cleanProduct.getBrand());
                }
                if(cleanProduct.getCategory() !=null){
                    userDb.get().setCategory(cleanProduct.getCategory());
                }
                if(cleanProduct.getPresentation() !=null){
                    userDb.get().setPresentation(cleanProduct.getPresentation());
                }
                if(cleanProduct.getDescription() !=null){
                    userDb.get().setDescription(cleanProduct.getDescription());
                }
                if(cleanProduct.getPrice() != 0.0){
                    userDb.get().setPrice(cleanProduct.getPrice());
                }
                if(cleanProduct.getQuantity() != 0){
                    userDb.get().setQuantity(cleanProduct.getQuantity());
                }
                if(cleanProduct.getPhotography() !=null){
                    userDb.get().setPhotography(cleanProduct.getPhotography());
                }
                
                userDb.get().setAvailability(cleanProduct.isAvailability());
                CleanProdRepository.update(userDb.get());
                return userDb.get();
            }else{
                return cleanProduct;
            }
        }else{
            return cleanProduct;
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
