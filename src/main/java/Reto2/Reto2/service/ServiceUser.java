/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2.Reto2.service;

import Reto2.Reto2.modelo.User;
import Reto2.Reto2.repository.RepositoryUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ncp19
 */
@Service
public class ServiceUser {
    @Autowired
     private RepositoryUser userRepository ;
    
     public List<User> getAll(){
        return userRepository.getAll();
    }
    
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    
     public User create (User user){
        if(user.getId()==null){
            return user;
        }else{
            Optional<User> evt=userRepository.getUser(user.getId());
            if(evt.isEmpty()){
                if(emailExists(user.getEmail())==false){
                    return userRepository.create(user);
                }else{
                    return user;
                }
                
            }else{
                return user;
            }
        }
    }
     
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }
    
    public User update(User user) {
        if (user.getId() == null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            
            if (!userDb.isEmpty()) {
                if(user.getIdentification() !=null){
                    userDb.get().setIdentification(user.getIdentification());
                }
                if(user.getName() !=null){
                    userDb.get().setName(user.getName());
                }
                if(user.getAddress() !=null){
                    userDb.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone() !=null){
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail() !=null){
                    userDb.get().setEmail(user.getEmail());
                }
                if(user.getZone() !=null){
                    userDb.get().setZone(user.getZone());
                }
                if(user.getType() !=null){
                    userDb.get().setType(user.getType());
                }
                
                userRepository.update(userDb.get());
                return userDb.get();
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    
    public boolean delete(int userId){
         Boolean aBoolean= getUser(userId).map(user ->{
            userRepository.delete(user);
            return true;
         }).orElse(false);
         return aBoolean;
    }
    
    
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
}
