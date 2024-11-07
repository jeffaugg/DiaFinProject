package com.jeffaugg.DiaFin.user.repository;

import com.jeffaugg.DiaFin.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}