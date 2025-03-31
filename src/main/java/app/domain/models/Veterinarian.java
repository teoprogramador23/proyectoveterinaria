package app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Veterinarian {
    private long veterinarianId;
    private String name;
    private String specialization;
}
