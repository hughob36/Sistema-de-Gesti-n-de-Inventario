package com.auth.service.auth_service.service;

import com.auth.service.auth_service.dto.RoleRequestDTO;
import com.auth.service.auth_service.dto.RoleResponseDTO;
import com.auth.service.auth_service.exception.ResourceNotFoundException;
import com.auth.service.auth_service.mapper.IRoleMapper;
import com.auth.service.auth_service.model.Permission;
import com.auth.service.auth_service.model.Role;
import com.auth.service.auth_service.repository.IPermissionRepository;
import com.auth.service.auth_service.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;
    private final IPermissionRepository permissionRepository;
    private final IRoleMapper roleMapper;

    @Override
    public List<RoleResponseDTO> findAll() {
        return roleMapper.toRoleResponseDTOList(roleRepository.findAll());
    }

    @Override
    public RoleResponseDTO findById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found."));
        return roleMapper.toRoleResponseDTO(role);
    }

    @Override
    public RoleResponseDTO save(RoleRequestDTO roleRequestDTO) {
        Role role = roleMapper.toRole(roleRequestDTO);
        Role roleValidate = this.validatePermissionsExists(role);
        return roleMapper.toRoleResponseDTO(roleRepository.save(roleValidate));
    }

    @Override
    public void deleteById(Long id) {
        if(!roleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id not found.");
        }
        roleRepository.deleteById(id);
    }

    @Override
    public RoleResponseDTO updateById(Long id, RoleRequestDTO roleRequestDTO) {
        Role roleFound = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found."));
        roleMapper.updateRoleFromDTO(roleRequestDTO,roleFound);
        Role roleValidate = this.validatePermissionsExists(roleFound);
        return roleMapper.toRoleResponseDTO(roleRepository.save(roleValidate));
    }

    public Role validatePermissionsExists(Role role) {
        Set<Permission> permissionSet = new HashSet<>();
        for(Permission permission : role.getPermissionSet()) {
            permissionRepository.findById(permission.getId()).ifPresent(permissionSet::add);
        }
        role.setPermissionSet(permissionSet);
        return role;
    }
}
