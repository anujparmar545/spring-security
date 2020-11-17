package com.anuj.security.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Anuj Parmar
 */
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
