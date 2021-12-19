/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2.Reto2.repository;


import Reto2.Reto2.interfaces.InterfaceOrder;
import Reto2.Reto2.modelo.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ncp19
 */
@Repository
public class RepositoryOrder {
    @Autowired
    private InterfaceOrder repository;

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return repository.findById(id);
    }
    public Order create(Order order) {
        return repository.save(order);
    }

    public void update(Order order) {
        repository.save(order);
    }
    
    public void delete(Order order) {
        repository.delete(order);
    }
    
    public Optional<Order> lastOrderId() {
         return repository.findToByOrderByIdDesc();
    }
    
    public List<Order> getorderByZone(String zona) {
        return repository.findByZone(zona);
    }
}
