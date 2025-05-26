package de.bbht.sample.backend.repository;

import de.bbht.sample.backend.model.PersonJpa;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository<PersonJpa, UUID> {

}
