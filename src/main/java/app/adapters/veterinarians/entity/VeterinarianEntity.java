package app.adapters.veterinarians.entity;

import app.domain.models.Veterinarian;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "veterinarian")
@Setter
@Getter
@NoArgsConstructor
public class VeterinarianEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veterinarian_id")
    private long veterinarianId;

    @Column(name = "name")
    private String name;

    @Column(name = "license_number")
    private String licenseNumber;

    public VeterinarianEntity(Veterinarian veterinarian) {
        this.veterinarianId = veterinarian.getVeterinarianId();
        this.name = veterinarian.getName();
        this.licenseNumber = veterinarian.getLicenseNumber();
    }
}

