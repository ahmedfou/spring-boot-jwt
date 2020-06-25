package com.ance.pfe.web.rest;

import com.ance.pfe.config.JwtTokenUtil;
import com.ance.pfe.domain.User;
import com.ance.pfe.service.IUserService;

import com.ance.pfe.service.impl.JwtUserDetailsService;
import com.ance.pfe.web.rest.errors.PfeException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {


    private final IUserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final JwtUserDetailsService userDetailsService;

    public UserController(IUserService userService,
                          AuthenticationManager authenticationManager,
                          JwtTokenUtil jwtTokenUtil,
                          JwtUserDetailsService userDetailsService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }


    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) throws PfeException {
        return userService.createUser(user);
    }


    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) throws PfeException {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")//url 
    public void updateUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
