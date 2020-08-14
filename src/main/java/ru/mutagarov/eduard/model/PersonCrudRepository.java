package ru.mutagarov.eduard.model;

import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository<Person, Long> {
}
