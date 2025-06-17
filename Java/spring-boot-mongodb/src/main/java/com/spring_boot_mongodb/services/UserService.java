package com.spring_boot_mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_mongodb.domain.User;
import com.spring_boot_mongodb.dto.UserDTO;
import com.spring_boot_mongodb.repository.UserRepository;
import com.spring_boot_mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        User user = repo.findById(id)
    .orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id));
        return user;
    }

    public User insert(User user) {
        return repo.insert(user);
    }

    public void delete(String id) {
        findById(id); 
        repo.deleteById(id);
    }

    public User update(User user) {
        User existingUser = findById(user.getId());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return repo.save(existingUser);
    }

    //If in the future you need acess database here is the correct way to do it no in UserDTO
    public User fromDTO(UserDTO user) {
        return new User(user.getId(), user.getName(), user.getEmail());
    }
}
