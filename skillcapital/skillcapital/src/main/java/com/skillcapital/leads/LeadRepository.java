package com.skillcapital.leads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//    LeadRepository: This class implements JpaRepository so that it can use all the Jpa In Built methods


@Repository
public interface LeadRepository extends JpaRepository<Lead, Long>
{
    // Method to check if email exists
    boolean existsByEmail(String email);

    // Method to find a lead by name and email (ignoring case)
    Optional<Lead> findByNameAndEmailIgnoreCase(String name, String email);

    Optional<Lead> findByNameIgnoreCase(String name);
}
