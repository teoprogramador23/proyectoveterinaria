package app.adapters.persons;

import app.adapters.persons.entity.PersonEntity;
import app.adapters.persons.repository.PersonRepository;
import app.domain.models.Person;
import app.ports.PersonPort;

public class PersonAdapter implements PersonPort {
   private PersonRepository personRepository;

   @Override
   public boolean existsPerson(long document) {
      return personRepository.existsByDocument(document);
   }

   @Override
   public void savePerson(Person person) {
      PersonEntity personEntity = new PersonEntity(person);
      personRepository.save(personEntity);
      person.setPersonId(personEntity.getPersonId());
   }

   @Override
   public Person findByDocument(long document) {
      PersonEntity personEntity = personRepository.findByDocument(document);
      return adaptPerson(personEntity);
   }

   private Person adaptPerson(PersonEntity personEntity) {
      Person person = new Person();
      person.setPersonId(personEntity.getPersonId());
      person.setDocument(personEntity.getDocument());
      person.setName(personEntity.getName());
      person.setPhone(personEntity.getPhone());
      return person;
   }
}

