package app.adapters.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    PersonEntity findByDocument(long document);
}
