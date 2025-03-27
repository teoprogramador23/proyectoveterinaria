package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MedicalRecord {
    private long recordId;
    private Pet pet;
    private Veterinarian veterinarian;
    private String diagnosis;
    private String treatment;
    private Date dateCreated;

    public MedicalRecord(long recordId, Pet pet, Veterinarian veterinarian, String diagnosis, String treatment, Date dateCreated) {
        this.recordId = recordId;
        this.pet = pet;
        this.veterinarian = veterinarian;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.dateCreated = dateCreated;
    }
}
