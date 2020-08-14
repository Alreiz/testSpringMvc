package ru.mutagarov.eduard.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonDataService {
    @Autowired PersonCrudRepository personCrudRepository;


    public void save(Person person) {
        personCrudRepository.save(person);
    }

    public List<Person> listAll() {
        return (List<Person>) personCrudRepository.findAll();
    }

    public void delete(Long id) {
        personCrudRepository.deleteById(id);
    }

    public Person get(Long id) {
        return personCrudRepository.findById(id).get();
    }
}
