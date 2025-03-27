package app.adapters.medicalorders.entity;

import app.adapters.pets.entity.PetEntity;
import app.adapters.veterinarians.entity.VeterinarianEntity;
import app.domain.models.MedicalOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "medical_order")
@Setter
@Getter
@NoArgsConstructor
public class MedicalOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private VeterinarianEntity veterinarian;

    @Column(name = "description")
    private String description;

    @Column(name = "date_created")
    private Date dateCreated;

    public MedicalOrderEntity(MedicalOrder medicalOrder) {
        this.orderId = medicalOrder.getOrderId();
        this.pet = new PetEntity(medicalOrder.getPet());
        this.veterinarian = new VeterinarianEntity(medicalOrder.getVeterinarian());
        this.description = medicalOrder.getDescription();
        this.dateCreated = medicalOrder.getDateCreated();
    }
}
