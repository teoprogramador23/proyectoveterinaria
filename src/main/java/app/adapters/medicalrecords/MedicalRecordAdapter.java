package app.adapters.medicalrecords;

import app.adapters.medicalrecords.entity.MedicalRecordEntity;
import app.adapters.medicalrecords.repository.MedicalRecordRepository;
import app.adapters.pets.entity.PetEntity;
import app.adapters.veterinarians.entity.VeterinarianEntity;
import app.domain.models.MedicalRecord;
import app.domain.models.Pet;
import app.domain.models.Veterinarian;
import app.ports.MedicalRecordPort;

import java.util.List;
import java.util.stream.Collectors;

public class MedicalRecordAdapter implements MedicalRecordPort {
    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordAdapter(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public void saveMedicalRecord(MedicalRecord medicalRecord) {
        MedicalRecordEntity medicalRecordEntity = medicalRecordEntityAdapter(medicalRecord);
        medicalRecordRepository.save(medicalRecordEntity);
        medicalRecord.setRecordId(medicalRecordEntity.getRecordId());
    }

    @Override
    public List<MedicalRecord> findRecordsByPet(Pet pet) {
        List<MedicalRecordEntity> records = medicalRecordRepository.findByPetId(pet.getPetId());
        return records.stream().map(this::medicalRecordAdapter).collect(Collectors.toList());
    }

    private MedicalRecord medicalRecordAdapter(MedicalRecordEntity entity) {
        return new MedicalRecord(
                entity.getRecordId(),
                new Pet(entity.getPet().getPetId(), entity.getPet().getName(), entity.getPet().getSpecies(), entity.getPet().getBreed(), entity.getPet().getAge(), null),
                new Veterinarian(entity.getVeterinarian().getVeterinarianId(), entity.getVeterinarian().getName(), entity.getVeterinarian().getLicenseNumber()),
                entity.getDiagnosis(),
                entity.getTreatment(),
                entity.getDateCreated()
        );
    }

    private MedicalRecordEntity medicalRecordEntityAdapter(MedicalRecord medicalRecord) {
        return new MedicalRecordEntity(medicalRecord);
    }
}
