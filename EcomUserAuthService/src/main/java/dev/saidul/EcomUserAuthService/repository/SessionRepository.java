package dev.saidul.EcomUserAuthService.repository;

import dev.saidul.EcomUserAuthService.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface SessionRepository extends JpaRepository<Session, UUID> {
    Optional<Session> findByTokenAndUserId(String token, UUID userId);
}
