package com.addresshub.address.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.addresshub.address.model.entity.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping(value = "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}
