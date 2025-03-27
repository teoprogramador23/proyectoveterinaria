package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pet {
    private long petId;
    private String name;
    private String species;
    private String breed;
    private int age;
    private Person owner;

    public Pet(long petId, String name, String species, String breed, int age, Person owner) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
    }
}
