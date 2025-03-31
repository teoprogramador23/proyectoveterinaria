package app.adapters.medicalorder;

import app.domain.models.MedicalOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medical_order")
@Getter
@Setter
@NoArgsConstructor
public class MedicalOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long medicalOrderId;

    private String description;

    public MedicalOrderEntity(MedicalOrder medicalOrder) {
        this.medicalOrderId = medicalOrder.getMedicalOrderId();
        this.description = medicalOrder.getDescription();
    }

    public MedicalOrder toModel() {
        return new MedicalOrder(medicalOrderId, description);
    }
}
