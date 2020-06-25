package com.ance.pfe.repository;

import com.ance.pfe.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByCin(String cin);

    User findByUsername(String username);
}
