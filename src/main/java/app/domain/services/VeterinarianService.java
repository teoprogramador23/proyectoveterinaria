package app.domain.services;

import app.domain.models.Veterinarian;
import app.ports.VeterinarianPort;

public class VeterinarianService {
    private final VeterinarianPort veterinarianPort;

    public VeterinarianService(VeterinarianPort veterinarianPort) {
        this.veterinarianPort = veterinarianPort;
    }

    public void registerVeterinarian(Veterinarian veterinarian) throws Exception {
        if (veterinarianPort.existsByLicenseNumber(veterinarian.getLicenseNumber())) {
            throw new Exception("A veterinarian with this license number already exists.");
        }
        veterinarianPort.saveVeterinarian(veterinarian);
    }
}
