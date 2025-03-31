package app.adapters.medicalrecord;

import app.domain.models.MedicalRecord;
import app.ports.MedicalRecordPort;
import java.util.List;

public class MedicalRecordAdapter implements MedicalRecordPort {
    private MedicalRecordRepository medicalRecordRepository;

    @Override
    public void saveMedicalRecord(MedicalRecord medicalRecord) {
        MedicalRecordEntity entity = new MedicalRecordEntity(medicalRecord);
        medicalRecordRepository.save(entity);
        medicalRecord.setMedicalRecordId(entity.getMedicalRecordId());
    }

    @Override
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll().stream()
                .map(MedicalRecordEntity::toModel)
                .toList();
    }
}

