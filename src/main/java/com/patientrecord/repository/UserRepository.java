package com.patientrecord.repository;

import com.patientrecord.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Long, User> {

    @EntityGraph(attributePaths = "roles")
    Optional<User> findByEmail(String email);
}
