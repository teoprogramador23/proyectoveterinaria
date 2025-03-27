package app.adapters.medicalorders;

import app.adapters.medicalorders.entity.MedicalOrderEntity;
import app.adapters.medicalorders.repository.MedicalOrderRepository;
import app.domain.models.MedicalOrder;
import app.domain.models.Pet;
import app.domain.models.Veterinarian;
import app.ports.MedicalOrderPort;

import java.util.List;
import java.util.stream.Collectors;

public class MedicalOrderAdapter implements MedicalOrderPort {
    private final MedicalOrderRepository medicalOrderRepository;

    public MedicalOrderAdapter(MedicalOrderRepository medicalOrderRepository) {
        this.medicalOrderRepository = medicalOrderRepository;
    }

    @Override
    public void saveMedicalOrder(MedicalOrder medicalOrder) {
        MedicalOrderEntity medicalOrderEntity = medicalOrderEntityAdapter(medicalOrder);
        medicalOrderRepository.save(medicalOrderEntity);
        medicalOrder.setOrderId(medicalOrderEntity.getOrderId());
    }

    @Override
    public List<MedicalOrder> findOrdersByPet(Pet pet) {
        return medicalOrderRepository.findByPetId(pet.getPetId()).stream()
                .map(this::medicalOrderAdapter)
                .collect(Collectors.toList());
    }

    private MedicalOrder medicalOrderAdapter(MedicalOrderEntity entity) {
        return new MedicalOrder(
                entity.getOrderId(),
                new Pet(entity.getPet().getPetId(), entity.getPet().getName(), entity.getPet().getSpecies(), entity.getPet().getBreed(), entity.getPet().getAge(), null),
                new Veterinarian(entity.getVeterinarian().getVeterinarianId(), entity.getVeterinarian().getName(), entity.getVeterinarian().getLicenseNumber()),
                entity.getDescription(),
                entity.getDateCreated()
        );
    }

    private MedicalOrderEntity medicalOrderEntityAdapter(MedicalOrder medicalOrder) {
        return new MedicalOrderEntity(medicalOrder);
    }
}
