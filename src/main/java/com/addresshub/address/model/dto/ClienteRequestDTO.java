package com.addresshub.address.model.dto;

import com.addresshub.address.model.entity.Endereco;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private Endereco endereco;

}
