package com.auth.service.auth_service.mapper;


import com.auth.service.auth_service.dto.RoleRequestDTO;
import com.auth.service.auth_service.dto.RoleResponseDTO;
import com.auth.service.auth_service.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoleMapper {

    public List<RoleResponseDTO> toRoleResponseDTOList(List<Role> roleList);
    public RoleResponseDTO toRoleResponseDTO(Role role);
    public Role toRole(RoleRequestDTO roleRequestDTO);

    public void updateRoleFromDTO(RoleRequestDTO dto, @MappingTarget Role role);
}
