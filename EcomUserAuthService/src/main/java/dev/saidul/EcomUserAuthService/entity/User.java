package dev.saidul.EcomUserAuthService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String email;
    private String phone;
    private String password;
    private String token;
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Role> roles;
    //@OneToMany
    //private List<Address> address;
}
