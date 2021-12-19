/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2.Reto2.service;

import Reto2.Reto2.modelo.Order;
import Reto2.Reto2.repository.RepositoryOrder;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author ncp19
 */
@Service
public class ServiceOrder {
    @Autowired
     private RepositoryOrder OrderRepository ;
    
     public List<Order> getAll(){
        return OrderRepository.getAll();
    }
    
    public Optional <Order> getOrder(Integer id){
        return OrderRepository.getOrder(id);
    }
    
    public Order create (Order order){
        Optional<Order> orderIdMaximo= OrderRepository.lastOrderId();
        if(order.getId() == null){
            if(orderIdMaximo.isEmpty()){
                order.setId(1);
            }else{
                 order.setId(orderIdMaximo.get().getId()+1);
            }
        }
        Optional<Order> existeorder= OrderRepository.getOrder(order.getId());
        if(existeorder.isEmpty()){
                return OrderRepository.create(order);
        }else{
                return order;
            }
    }
    
    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> orderDb = OrderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getRegisterDay()!= null) {
                    orderDb.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orderDb.get().setSalesMan(order.getSalesMan());
                }
                if (order.getProducts()!= null) {
                    orderDb.get().setProducts(order.getProducts());
                }
                if (order.getQuantities()!= null) {
                    orderDb.get().setQuantities(order.getQuantities());
                }
             OrderRepository.update(orderDb.get());
                return orderDb.get();
            }else {
                return order;
            }
        }else{
            return order;
        }
    }
    
    public boolean delete(int orderId){
        return getOrder(orderId).map(order ->{
            OrderRepository.delete(order);
            return true;
         }).orElse(false);
    }
    
    public List<Order> getfindByZone(String zona) {
        return OrderRepository.getorderByZone(zona);
    }
}
