package app.adapters.pets.entity;

import app.adapters.persons.entity.PersonEntity;
import app.domain.models.Pet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pet")
@Setter
@Getter
@NoArgsConstructor
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private long petId;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "breed")
    private String breed;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private PersonEntity owner;

    public PetEntity(Pet pet) {
        this.petId = pet.getPetId();
        this.name = pet.getName();
        this.species = pet.getSpecies();
        this.breed = pet.getBreed();
        this.age = pet.getAge();
        this.owner = new PersonEntity(pet.getOwner());
    }
}
