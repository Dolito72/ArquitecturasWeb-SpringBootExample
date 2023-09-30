package com.example.springbootexample.service.dto.cliente.response;

import com.example.springbootexample.domain.Cliente;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClienteResponseDTO {

    private final Long id;
    private final String nombre;
    private final String email;

    public ClienteResponseDTO( Cliente c ) {
        this.id = c.getId();
        this.nombre = c.getNombre();
        this.email = c.getEmail();
    }

}
