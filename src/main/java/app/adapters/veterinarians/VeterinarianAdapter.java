package app.adapters.veterinarians;

import app.adapters.veterinarians.entity.VeterinarianEntity;
import app.adapters.veterinarians.repository.VeterinarianRepository;
import app.domain.models.Veterinarian;
import app.ports.VeterinarianPort;

import java.util.List;
import java.util.stream.Collectors;

public class VeterinarianAdapter implements VeterinarianPort {
    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianAdapter(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    @Override
    public void saveVeterinarian(Veterinarian veterinarian) {
        VeterinarianEntity veterinarianEntity = veterinarianEntityAdapter(veterinarian);
        veterinarianRepository.save(veterinarianEntity);
        veterinarian.setVeterinarianId(veterinarianEntity.getVeterinarianId());
    }

    @Override
    public List<Veterinarian> findAllVeterinarians() {
        return veterinarianRepository.findAll().stream()
                .map(this::veterinarianAdapter)
                .collect(Collectors.toList());
    }

    private Veterinarian veterinarianAdapter(VeterinarianEntity entity) {
        return new Veterinarian(
                entity.getVeterinarianId(),
                entity.getName(),
                entity.getLicenseNumber()
        );
    }

    private VeterinarianEntity veterinarianEntityAdapter(Veterinarian veterinarian) {
        return new VeterinarianEntity(veterinarian);
    }
}
