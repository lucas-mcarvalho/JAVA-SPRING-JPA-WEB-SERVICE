package com.plataform.Project_2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.plataform.Project_2.entities.User;
import com.plataform.Project_2.repositories.UserRepository;
import com.plataform.Project_2.services.exceptions.DatabaseException;
import com.plataform.Project_2.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    //PERMITE USAR A CLASSE SEM INSTANCIAR ELA
    @Autowired
    private UserRepository userrepository;

    public List<User> findAll() {
        return userrepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userrepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userrepository.save(user);
    }

    public void delete(Long id) {
        try {
            userrepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        try {
            User entity = userrepository.getReferenceById(id);

            updateDate(entity, user);
            return userrepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDate(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());


    }
}
