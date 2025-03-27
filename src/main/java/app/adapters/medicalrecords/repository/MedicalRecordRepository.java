package app.adapters.medicalrecords.repository;

import app.adapters.medicalrecords.entity.MedicalRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecordEntity, Long> {
    List<MedicalRecordEntity> findByPetId(long petId);
}
