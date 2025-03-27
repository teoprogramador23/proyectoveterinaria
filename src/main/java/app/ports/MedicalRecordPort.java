package app.ports;

import app.domain.models.MedicalRecord;
import app.domain.models.Pet;
import java.util.List;

public interface MedicalRecordPort {
    void saveMedicalRecord(MedicalRecord medicalRecord);
    List<MedicalRecord> findRecordsByPet(Pet pet);
}
