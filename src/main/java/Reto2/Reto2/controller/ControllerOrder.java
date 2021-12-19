/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2.Reto2.controller;


import Reto2.Reto2.modelo.Order;
import Reto2.Reto2.service.ServiceOrder;
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
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class ControllerOrder {
     @Autowired
    private ServiceOrder orderService;
     
     @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }
    
     @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id){
        return orderService.getOrder(id);
    }
      @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }
    
    @GetMapping("/zona/{zone}")
    public List<Order> getOrderByZone(@PathVariable("zone") String zone) {
        return orderService.getfindByZone(zone);
    }
}
