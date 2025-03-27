package app.adapters.medicalorders.repository;

import app.adapters.medicalorders.entity.MedicalOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicalOrderRepository extends JpaRepository<MedicalOrderEntity, Long> {
    List<MedicalOrderEntity> findByPetId(long petId);
}
