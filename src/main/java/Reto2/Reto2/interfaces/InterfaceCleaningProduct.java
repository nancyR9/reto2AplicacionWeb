/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2.Reto2.interfaces;


import Reto2.Reto2.modelo.CleaningProduct;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ncp19
 */
public interface InterfaceCleaningProduct extends MongoRepository<CleaningProduct, Integer> {
   
}
