package com.addresshub.address.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.addresshub.address.model.dto.ClienteRequestDTO;
import com.addresshub.address.model.dto.ClienteResponseDTO;
import com.addresshub.address.model.entity.Cliente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, 
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteRequestDTO dto);

    ClienteResponseDTO toResponseDTO(Cliente entity);

    List<ClienteResponseDTO> toResponseDTOList(List<Cliente> entities);

}
