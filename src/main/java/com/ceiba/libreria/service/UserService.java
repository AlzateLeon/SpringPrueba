package com.ceiba.libreria.service;

import com.ceiba.libreria.entity.User;
import com.ceiba.libreria.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final Log log = LogFactory.getLog(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional // permite hacer un rollback de las inserciones a las bases de datos
    public void saveInformation(List<User> users){
        users.stream().peek(user -> {
            log.info("usuario insertado: " + user);
        }).forEach(userRepository::save);

    }

    public List<User> getAllusers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User use, Long id) {
        return userRepository.findById(id).map(u ->{
            u.setMail(use.getMail());
            u.setName(use.getName());
            u.setBirthDate(use.getBirthDate());
            return userRepository.save(u);
        }).orElse(null);
    }
}
