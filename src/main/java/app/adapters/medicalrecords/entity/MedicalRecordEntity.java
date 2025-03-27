package app.adapters.medicalrecords.entity;

import app.adapters.pets.entity.PetEntity;
import app.adapters.veterinarians.entity.VeterinarianEntity;
import app.domain.models.MedicalRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "medical_record")
@Setter
@Getter
@NoArgsConstructor
public class MedicalRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private long recordId;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private VeterinarianEntity veterinarian;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "date_created")
    private Date dateCreated;

    public MedicalRecordEntity(MedicalRecord medicalRecord) {
        this.recordId = medicalRecord.getRecordId();
        this.pet = new PetEntity(medicalRecord.getPet());
        this.veterinarian = new VeterinarianEntity(medicalRecord.getVeterinarian());
        this.diagnosis = medicalRecord.getDiagnosis();
        this.treatment = medicalRecord.getTreatment();
        this.dateCreated = medicalRecord.getDateCreated();
    }
}
