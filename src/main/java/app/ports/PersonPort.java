package app.ports;

import app.domain.models.Person;

public interface PersonPort {
   boolean existsPerson(long document);
   void savePerson(Person person);
   Person findByDocument(long document);
}
