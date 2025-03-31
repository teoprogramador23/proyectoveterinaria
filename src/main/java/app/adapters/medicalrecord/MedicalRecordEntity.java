package app.adapters.medicalrecord;

import app.domain.models.MedicalRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medical_record")
@Getter
@Setter
@NoArgsConstructor
public class MedicalRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long medicalRecordId;

    private String details;

    public MedicalRecordEntity(MedicalRecord medicalRecord) {
        this.medicalRecordId = medicalRecord.getMedicalRecordId();
        this.details = medicalRecord.getDetails();
    }

    public MedicalRecord toModel() {
        return new MedicalRecord(medicalRecordId, details);
    }
}
