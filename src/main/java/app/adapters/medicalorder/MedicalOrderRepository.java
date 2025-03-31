package app.adapters.medicalorder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalOrderRepository extends JpaRepository<MedicalOrderEntity, Long> {
}
