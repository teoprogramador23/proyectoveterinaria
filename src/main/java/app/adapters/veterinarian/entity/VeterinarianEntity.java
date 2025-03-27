package app.adapters.veterinarian.entity;

import app.domain.models.Veterinarian;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "veterinarian")
@Getter
@Setter
@NoArgsConstructor
public class VeterinarianEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long veterinarianId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "license_number", unique = true, nullable = false)
    private String licenseNumber;

    public VeterinarianEntity(Veterinarian veterinarian) {
        this.veterinarianId = veterinarian.getVeterinarianId();
        this.name = veterinarian.getName();
        this.licenseNumber = veterinarian.getLicenseNumber();
    }
}
