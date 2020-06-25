package com.ance.pfe.service;

import com.ance.pfe.domain.User;
import com.ance.pfe.web.rest.errors.PfeException;

import java.util.List;

public interface IUserService {

    User getUserById(Long id);

    List<User> getAllUsers();

    User createUser(User user) throws PfeException;

    User updateUser(User user) throws PfeException;

    void deleteUser(Long id);
}
