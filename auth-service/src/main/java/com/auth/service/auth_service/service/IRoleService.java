package com.auth.service.auth_service.service;


import com.auth.service.auth_service.dto.RoleRequestDTO;
import com.auth.service.auth_service.dto.RoleResponseDTO;
import com.auth.service.auth_service.model.Role;

import java.util.List;

public interface IRoleService {

    public List<RoleResponseDTO> findAll();
    public RoleResponseDTO findById(Long id);
    public RoleResponseDTO save(RoleRequestDTO roleRequestDTO);
    public void deleteById(Long id);
    public RoleResponseDTO updateById(Long id, RoleRequestDTO roleRequestDTO);
}
