package app.ports;

import app.domain.models.Pet;
import app.domain.models.Person;
import java.util.List;

public interface PetPort {
    void savePet(Pet pet);
    List<Pet> findPetsByOwner(Person owner);
}
