package app.adapters.pet;

import app.domain.models.Pet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pet")
@Getter
@Setter
@NoArgsConstructor
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long petId;

    private String name;
    private String species;

    public PetEntity(Pet pet) {
        this.petId = pet.getPetId();
        this.name = pet.getName();
        this.species = pet.getSpecies();
    }

    public Pet toModel() {
        return new Pet(petId, name, species);
    }
}
