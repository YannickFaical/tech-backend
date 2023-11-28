package com.tech.techbackend.repository;

import com.tech.techbackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client,Integer>{
Client  findByEmail(String email);
}
