package com.addresshub.address.service.impl;

import com.addresshub.address.model.dto.ClienteRequestDTO;
import com.addresshub.address.model.dto.ClienteResponseDTO;
import com.addresshub.address.model.entity.Cliente;
import com.addresshub.address.model.entity.Endereco;
import com.addresshub.address.model.mapper.ClienteMapper;
import com.addresshub.address.model.repository.ClienteRepository;
import com.addresshub.address.model.repository.EnderecoRepository;
import com.addresshub.address.service.ClienteService;
import com.addresshub.address.service.ViaCepClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ViaCepClient viaCepClient;

    @Override
    public List<ClienteResponseDTO> buscarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toResponseDTOList(clientes);

    }

    @Override
    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        
        return clienteMapper.toResponseDTO(cliente);
    }

    @Override
    public ClienteResponseDTO inserir(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteRequestDTO);
        salvarClienteComCep(cliente);
        return clienteMapper.toResponseDTO(cliente);
    }

    @Override
    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO clienteRequestDTO) {
        Cliente clienteAtual = clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cliente clienteAtualizado = clienteMapper.toEntity(clienteRequestDTO);
        clienteAtualizado.setId(clienteAtual.getId());
        salvarClienteComCep(clienteAtualizado);

        return clienteMapper.toResponseDTO(clienteAtualizado);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepClient.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
