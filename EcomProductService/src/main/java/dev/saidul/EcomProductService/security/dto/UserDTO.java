package dev.saidul.EcomProductService.security.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private String email;
    private Set<Role> roles = new HashSet<>();
}
