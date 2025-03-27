package app.adapters.veterinarian.repository;

import app.adapters.veterinarian.entity.VeterinarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepository extends JpaRepository<VeterinarianEntity, Long> {
    boolean existsByLicenseNumber(String licenseNumber);
}
