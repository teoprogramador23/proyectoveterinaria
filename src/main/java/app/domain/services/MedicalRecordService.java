package app.domain.services;

import app.domain.models.MedicalRecord;
import app.ports.MedicalRecordPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    private final MedicalRecordPort medicalRecordPort;

    public MedicalRecordService(MedicalRecordPort medicalRecordPort) {
        this.medicalRecordPort = medicalRecordPort;
    }

    public void createMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordPort.saveMedicalRecord(medicalRecord);
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordPort.getAllMedicalRecords();
    }

    public MedicalRecord getMedicalRecordById(long medicalRecordId) {
        return medicalRecordPort.findById(medicalRecordId);
    }
}
