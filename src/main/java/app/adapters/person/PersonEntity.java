
package app.adapters.person;

import app.domain.models.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;

    private long document;
    private String name;
    private long phone;

    public PersonEntity(Person person) {
        this.personId = person.getPersonId();
        this.document = person.getDocument();
        this.name = person.getName();
        this.phone = person.getPhone();
    }

    public Person toModel() {
        return new Person(personId, document, name, phone);
    }
}
