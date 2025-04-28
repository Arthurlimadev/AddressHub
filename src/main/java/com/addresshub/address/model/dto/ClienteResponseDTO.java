package com.addresshub.address.model.dto;

import com.addresshub.address.model.entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDTO {

    private String nome;
    private Endereco endereco;

}
