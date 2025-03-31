package app.ports;

import app.domain.models.MedicalRecord;
import java.util.List;

public interface MedicalRecordPort {
    void saveMedicalRecord(MedicalRecord medicalRecord);
    List<MedicalRecord> getAllMedicalRecords();
    MedicalRecord findById(long medicalRecordId);
}

