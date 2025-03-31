package app.domain.services;

import app.domain.models.Person;
import app.ports.PersonPort;

public class PersonService {
    private final PersonPort personPort;

    public PersonService(PersonPort personPort) {
        this.personPort = personPort;
    }

    public void registerPerson(Person person) {
        personPort.savePerson(person);
    }
}
