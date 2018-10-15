package ru.degtyar.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.degtyar.springboot.model.Person;
import ru.degtyar.springboot.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class PersonService {


    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> findAll(Sort sort) {
        return personRepository.findAll(sort);
    }

    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public <S extends Person> S save(S s) {
        return personRepository.save(s);
    }

    public <S extends Person> Iterable<S> saveAll(Iterable<S> iterable) {
        return personRepository.saveAll(iterable);
    }

    public Optional<Person> findById(String s) {
        return personRepository.findById(s);
    }

    public boolean existsById(String s) {
        return personRepository.existsById(s);
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Iterable<Person> findAllById(Iterable<String> iterable) {
        return personRepository.findAllById(iterable);
    }

    public long count() {
        return personRepository.count();
    }

    public void deleteById(String s) {
        personRepository.deleteById(s);
    }

    public void delete(Person person) {
        personRepository.delete(person);
    }

    public void deleteAll(Iterable<? extends Person> iterable) {
        personRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }
}
