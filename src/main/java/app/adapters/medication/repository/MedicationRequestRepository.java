package app.adapters.medication.repository;

import app.adapters.medication.entity.MedicationRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicationRequestRepository extends JpaRepository<MedicationRequestEntity, Long> {
    List<MedicationRequestEntity> findByStatus(String status);
}
