package app.adapters.persons.entity;

import app.domain.models.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Setter
@Getter
@NoArgsConstructor
public class PersonEntity {
   public PersonEntity(Person person) {
      this.personId = person.getPersonId();
      this.document = person.getDocument();
      this.name = person.getName();
      this.phone = person.getPhone();
   }

   @Id
   @Column(name = "id")
   private long personId;
   
   @Column(name = "document")
   private long document;
   
   @Column(name = "name")
   private String name;
   
   @Column(name = "phone")
   private long phone;
}

