package app.adapters.pets.repository;

import app.adapters.pets.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PetRepository extends JpaRepository<PetEntity, Long> {
    List<PetEntity> findByOwnerId(long ownerId);
}
