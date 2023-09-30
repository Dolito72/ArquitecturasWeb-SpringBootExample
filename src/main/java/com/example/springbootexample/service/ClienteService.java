package com.example.springbootexample.service;

import com.example.springbootexample.domain.Cliente;
import com.example.springbootexample.repository.ClienteRepository;
import com.example.springbootexample.service.dto.cliente.request.ClienteRequestDTO;
import com.example.springbootexample.service.dto.cliente.response.ClienteResponseDTO;
import com.example.springbootexample.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
	private final ClienteRepository clienteRepository;

    @Transactional
    public ClienteResponseDTO save(ClienteRequestDTO request ){
        final var cliente = new Cliente( request );
        final var result = this.clienteRepository.save( cliente );
        return new ClienteResponseDTO( result.getId(), result.getNombre(), result.getEmail() );
    }

    @Transactional( readOnly = true )
    public List<ClienteResponseDTO> findAll(){
        return this.clienteRepository.findAll().stream().map( ClienteResponseDTO::new ).toList();
    }

    @Transactional( readOnly = true )
    public ClienteResponseDTO findById( Long id ){
        return this.clienteRepository.findById( id )
                .map( ClienteResponseDTO::new )
                .orElseThrow( () -> new NotFoundException("Cliente", id ) );
    }

    @Transactional( readOnly = true )
    public List<ClienteResponseDTO> search( ClienteRequestDTO request ){
        return this.clienteRepository.search( request.getNombre(), request.getEmail() )
                .stream().map( ClienteResponseDTO::new ).toList();
    }

}
