package app.adapters.veterinarian;

import app.adapters.veterinarian.entity.VeterinarianEntity;
import app.adapters.veterinarian.repository.VeterinarianRepository;
import app.domain.models.Veterinarian;
import app.ports.VeterinarianPort;

public class VeterinarianAdapter implements VeterinarianPort {
    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianAdapter(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    @Override
    public boolean existsByLicenseNumber(String licenseNumber) {
        return veterinarianRepository.existsByLicenseNumber(licenseNumber);
    }

    @Override
    public void saveVeterinarian(Veterinarian veterinarian) {
        VeterinarianEntity entity = new VeterinarianEntity(veterinarian);
        veterinarianRepository.save(entity);
        veterinarian.setVeterinarianId(entity.getVeterinarianId());
    }
}
