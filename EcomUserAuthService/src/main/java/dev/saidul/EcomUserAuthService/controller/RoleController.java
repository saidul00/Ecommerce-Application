package dev.saidul.EcomUserAuthService.controller;

import dev.saidul.EcomUserAuthService.dto.CreateRoleRequestDTO;
import dev.saidul.EcomUserAuthService.dto.RoleResponseDTO;
import dev.saidul.EcomUserAuthService.entity.Role;
import dev.saidul.EcomUserAuthService.exception.RoleAlreadyExistException;
import dev.saidul.EcomUserAuthService.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;
    public RoleController(RoleService roleService){
        this.roleService=roleService;
    }

    @PostMapping
    public ResponseEntity<RoleResponseDTO> crateRole(@RequestBody CreateRoleRequestDTO requestDTO) throws RoleAlreadyExistException {
        RoleResponseDTO responseDTO = roleService.createRole(requestDTO);
        return ResponseEntity.ok(
                responseDTO
        );
    }
}
