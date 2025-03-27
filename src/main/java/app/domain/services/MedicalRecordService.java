package app.domain.services;

import app.domain.models.MedicalRecord;
import app.domain.models.Pet;
import app.ports.MedicalRecordPort;

import java.util.List;

public class MedicalRecordService {
    private final MedicalRecordPort medicalRecordPort;

    public MedicalRecordService(MedicalRecordPort medicalRecordPort) {
        this.medicalRecordPort = medicalRecordPort;
    }

    public void createMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordPort.saveMedicalRecord(medicalRecord);
    }

    public List<MedicalRecord> getRecordsByPet(Pet pet) {
        return medicalRecordPort.findRecordsByPet(pet);
    }
}
