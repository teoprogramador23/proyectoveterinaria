package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Veterinarian {
    private long veterinarianId;
    private String name;
    private String licenseNumber;

    public Veterinarian(long veterinarianId, String name, String licenseNumber) {
        this.veterinarianId = veterinarianId;
        this.name = name;
        this.licenseNumber = licenseNumber;
    }
}

