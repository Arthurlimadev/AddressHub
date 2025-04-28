package com.addresshub.address.service;

import java.util.List;

import com.addresshub.address.model.dto.ClienteRequestDTO;
import com.addresshub.address.model.dto.ClienteResponseDTO;

public interface ClienteService {

    List<ClienteResponseDTO> buscarTodos();

    ClienteResponseDTO buscarPorId(Long id);

    ClienteResponseDTO inserir(ClienteRequestDTO clienteRequestDTO);

    ClienteResponseDTO atualizar(Long id, ClienteRequestDTO clienteRequestDTO);

    void delete(Long id);

}
