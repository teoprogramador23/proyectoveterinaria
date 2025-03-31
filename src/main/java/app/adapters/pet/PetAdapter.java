package app.adapters.pet;

import app.domain.models.Pet;
import app.ports.PetPort;
import java.util.List;

public class PetAdapter implements PetPort {
    private PetRepository petRepository;

    @Override
    public void savePet(Pet pet) {
        PetEntity entity = new PetEntity(pet);
        petRepository.save(entity);
        pet.setPetId(entity.getPetId());
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll().stream()
                .map(PetEntity::toModel)
                .toList();
    }
}
