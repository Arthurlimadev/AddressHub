package com.addresshub.address.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.addresshub.address.model.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
