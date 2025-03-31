package app.controllers;

import app.domain.models.Pet;
import app.domain.services.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/register")
    public void registerPet(@RequestBody Pet pet) {
        petService.registerPet(pet);
    }

    @GetMapping("/all")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }
}
