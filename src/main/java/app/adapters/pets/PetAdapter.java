package app.adapters.pets;

import app.adapters.pets.entity.PetEntity;
import app.adapters.pets.repository.PetRepository;
import app.domain.models.Pet;
import app.domain.models.Person;
import app.ports.PetPort;

import java.util.List;
import java.util.stream.Collectors;

public class PetAdapter implements PetPort {
    private final PetRepository petRepository;

    public PetAdapter(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void savePet(Pet pet) {
        PetEntity petEntity = petEntityAdapter(pet);
        petRepository.save(petEntity);
        pet.setPetId(petEntity.getPetId());
    }

    @Override
    public List<Pet> findPetsByOwner(Person owner) {
        List<PetEntity> petEntities = petRepository.findByOwnerId(owner.getPersonId());
        return petEntities.stream().map(this::petAdapter).collect(Collectors.toList());
    }

    private Pet petAdapter(PetEntity petEntity) {
        return new Pet(
                petEntity.getPetId(),
                petEntity.getName(),
                petEntity.getSpecies(),
                petEntity.getBreed(),
                petEntity.getAge(),
                new Person(petEntity.getOwner().getPersonId(), petEntity.getOwner().getDocument(), petEntity.getOwner().getName(), petEntity.getOwner().getCellPhone())
        );
    }

    private PetEntity petEntityAdapter(Pet pet) {
        return new PetEntity(pet);
    }
}
