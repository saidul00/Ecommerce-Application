package dev.saidul.EcomUserAuthService.service;

import dev.saidul.EcomUserAuthService.dto.CreateRoleRequestDTO;
import dev.saidul.EcomUserAuthService.dto.RoleResponseDTO;
import dev.saidul.EcomUserAuthService.entity.Role;
import dev.saidul.EcomUserAuthService.exception.RoleAlreadyExistException;
import dev.saidul.EcomUserAuthService.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    public RoleResponseDTO createRole(CreateRoleRequestDTO requestDTO) throws RoleAlreadyExistException {
        Optional<Role> roleOptional = roleRepository.findByRoleName(requestDTO.getRoleName());
        if(roleOptional.isPresent()){
            throw new RoleAlreadyExistException("Role: "+requestDTO.getRoleName()+" already exist");
        }
        Role role = new Role();
        role.setRoleName(requestDTO.getRoleName());
        Role savedRole = roleRepository.save(role);
        return RoleResponseDTO.from(savedRole);
    }
}
