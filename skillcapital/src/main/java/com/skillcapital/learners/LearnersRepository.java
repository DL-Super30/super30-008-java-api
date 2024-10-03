package com.skillcapital.learners;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LearnersRepository extends JpaRepository<Learners, Long> {

    // Method to find learners by email
    boolean existsByEmail(String email);

    // Method to find a learner by first name, last name, and email (ignoring case)
    Optional<Learners> findByFirstNameAndLastNameAndEmailIgnoreCase(String firstName, String lastName, String email);

    // Method to find learners by first name and last name (case-insensitive)
    List<Learners> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);
}
