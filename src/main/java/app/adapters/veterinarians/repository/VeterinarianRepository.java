package app.adapters.veterinarians.repository;

import app.adapters.veterinarians.entity.VeterinarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepository extends JpaRepository<VeterinarianEntity, Long> {
}

