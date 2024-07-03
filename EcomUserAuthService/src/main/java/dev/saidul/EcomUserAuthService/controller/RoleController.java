package dev.saidul.EcomUserAuthService.controller;

import dev.saidul.EcomUserAuthService.dto.CreateRoleRequestDTO;
import dev.saidul.EcomUserAuthService.entity.Role;
import dev.saidul.EcomUserAuthService.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleService roleService;
    public RoleController(RoleService roleService){
        this.roleService=roleService;
    }

    @PostMapping
    public ResponseEntity<Role> crateRole(@PathVariable CreateRoleRequestDTO requestDTO){
        return null;
    }
}
