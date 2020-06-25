package com.ance.pfe.service;

import com.ance.pfe.domain.User;
import com.ance.pfe.repository.UserRepository;
import com.ance.pfe.web.rest.errors.PfeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) throws PfeException {

        User userToFind = userRepository.findUserByCin(user.getCin());

        if(userToFind == null) {
            user.setUsername(user.getEmail());
            user.setPassword(bcryptEncoder.encode(user.getPassword()));

        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws PfeException {

        User userToFind = userRepository.findUserByCin(user.getCin());

        if((userToFind != null)  && (userToFind.getId() != user.getId())) {
            throw new PfeException("user alredy exist");
        }

        User oldUser = userRepository.findById(user.getId()).get();

        oldUser.setCin(user.getCin());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastNom(user.getLastNom());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
