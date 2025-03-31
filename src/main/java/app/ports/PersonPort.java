package app.ports;

import app.domain.models.Person;

public interface PersonPort {
    void savePerson(Person person);
    Person findByDocument(long document);
}

