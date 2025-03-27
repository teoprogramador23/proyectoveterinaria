package app.ports;

import app.domain.models.Veterinarian;

public interface VeterinarianPort {
    boolean existsByLicenseNumber(String licenseNumber);
    void saveVeterinarian(Veterinarian veterinarian);
}
