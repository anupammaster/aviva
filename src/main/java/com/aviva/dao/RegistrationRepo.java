package com.aviva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.aviva.model.Registration;

@Service
public interface RegistrationRepo extends JpaRepository<Registration, Integer> {

}
