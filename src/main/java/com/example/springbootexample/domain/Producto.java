package com.example.springbootexample.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String nombre;
    private float valor;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "producto")
    private Set<FacturaProducto> facturaProductos;

}
