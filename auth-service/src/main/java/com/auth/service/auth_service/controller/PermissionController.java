package com.auth.service.auth_service.controller;

import com.auth.service.auth_service.model.Permission;
import com.auth.service.auth_service.service.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permission")
@RequiredArgsConstructor
public class PermissionController {

    private final IPermissionService  permissionService;

    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermission() {
        return ResponseEntity.ok(permissionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionFindById(@PathVariable Long id) {
        return ResponseEntity.ok(permissionService.findBYId(id));
    }

    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(permissionService.save(permission));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePermissionByIs(@PathVariable Long id) {
        permissionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermissionById(@PathVariable Long id, @RequestBody Permission permission) {
        return ResponseEntity.ok(permissionService.updateById(id,permission));
    }

}
