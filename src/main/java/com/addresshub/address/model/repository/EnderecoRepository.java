package com.addresshub.address.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.addresshub.address.model.entity.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
