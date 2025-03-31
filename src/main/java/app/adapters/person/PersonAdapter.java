package app.adapters.person;

import app.domain.models.Person;
import app.ports.PersonPort;

public class PersonAdapter implements PersonPort {
    private PersonRepository personRepository;

    @Override
    public void savePerson(Person person) {
        PersonEntity entity = new PersonEntity(person);
        personRepository.save(entity);
        person.setPersonId(entity.getPersonId());
    }

    @Override
    public Person findByDocument(long document) {
        return personRepository.findByDocument(document).toModel();
    }
}
