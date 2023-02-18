package hu.aestallon.adrestore.repository;

import hu.aestallon.adrestore.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
