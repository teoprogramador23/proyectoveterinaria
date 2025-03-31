package app.ports;

import app.domain.models.Pet;
import java.util.List;

public interface PetPort {
    void savePet(Pet pet);
    List<Pet> getAllPets();
}
