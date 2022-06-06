package com.noqtech.noq.repository;

import com.noqtech.noq.entity.NoQUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<NoQUser, Integer> {
    NoQUser findByEmailId(String emailId);
}
