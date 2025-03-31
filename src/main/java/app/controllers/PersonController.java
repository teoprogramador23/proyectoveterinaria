package app.controllers;

import app.domain.models.Person;
import app.domain.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/register")
    public void registerPerson(@RequestBody Person person) {
        personService.registerPerson(person);
    }

    @GetMapping("/{document}")
    public Person getPersonByDocument(@PathVariable long document) {
        return personService.getPersonByDocument(document);
    }
}
