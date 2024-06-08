package dev.saidul.EcomUserAuthService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface Role extends JpaRepository<Role, UUID> {
}
