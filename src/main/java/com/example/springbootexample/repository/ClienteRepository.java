package com.example.springbootexample.repository;

import com.example.springbootexample.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query( "SELECT c " +
            "FROM Cliente c " +
            "WHERE (:nombre IS NULL OR c.nombre LIKE :nombre) " +
            "AND ( :email IS NULL OR c.email LIKE :email ) ")
    List<Cliente> search(String nombre, String email);
}
