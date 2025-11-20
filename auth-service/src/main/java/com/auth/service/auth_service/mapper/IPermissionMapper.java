package com.auth.service.auth_service.mapper;

import com.auth.service.auth_service.dto.PermissionRequestDTO;
import com.auth.service.auth_service.dto.PermissionResponseDTO;
import com.auth.service.auth_service.model.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPermissionMapper {

    public List<PermissionResponseDTO> toPermissionResponseDTOList(List<Permission> permissionList);
    public PermissionResponseDTO toPermissionResponseDTO(Permission permission);
    public Permission toPermission(PermissionRequestDTO permissionRequestDTO);

    public void updatePermissionFromDto(PermissionRequestDTO dto, @MappingTarget Permission permission);

}
