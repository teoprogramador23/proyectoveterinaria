package app.adapters.medication.entity;

import app.domain.models.MedicationRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medication_request")
@Setter
@Getter
@NoArgsConstructor
public class MedicationRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long requestId;

    private long userId;
    private String medicationName;
    private String status;

    public MedicationRequestEntity(MedicationRequest request) {
        this.requestId = request.getRequestId();
        this.userId = request.getUserId();
        this.medicationName = request.getMedicationName();
        this.status = request.getStatus();
    }

    public MedicationRequest toModel() {
        return new MedicationRequest(requestId, userId, medicationName, status);
    }
}

