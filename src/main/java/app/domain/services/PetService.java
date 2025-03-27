package app.domain.services;

import app.domain.models.Pet;
import app.domain.models.Person;
import app.ports.PetPort;

import java.util.List;

public class PetService {
    private final PetPort petPort;

    public PetService(PetPort petPort) {
        this.petPort = petPort;
    }

    public void registerPet(Pet pet) {
        petPort.savePet(pet);
    }

    public List<Pet> getPetsByOwner(Person owner) {
        return petPort.findPetsByOwner(owner);
    }
}
