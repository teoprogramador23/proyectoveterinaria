package app.adapters.veterinarian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.adapters.veterinarian.entity.VeterinarianEntity;

public interface VeterinarianRepository extends JpaRepository<VeterinarianEntity, Long> {
   VeterinarianEntity findByUserId(long userId);
   int countBySpecialty(String specialty);
}
