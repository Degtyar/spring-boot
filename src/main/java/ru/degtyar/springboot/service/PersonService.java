package ru.degtyar.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.degtyar.springboot.model.Person;
import ru.degtyar.springboot.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findAll(Sort sort) {
        return personRepository.findAll(sort);
    }

    public List<Person> findAllById(Iterable<String> iterable) {
        return personRepository.findAllById(iterable);
    }

    public <S extends Person> List<S> saveAll(Iterable<S> iterable) {
        return personRepository.saveAll(iterable);
    }

    public void flush() {
        personRepository.flush();
    }

    public <S extends Person> S saveAndFlush(S s) {
        return personRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Person> iterable) {
        personRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        personRepository.deleteAllInBatch();
    }

    public Person getOne(String s) {
        return personRepository.getOne(s);
    }

    public <S extends Person> List<S> findAll(Example<S> example) {
        return personRepository.findAll(example);
    }

    public <S extends Person> List<S> findAll(Example<S> example, Sort sort) {
        return personRepository.findAll(example, sort);
    }

    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public <S extends Person> S save(S s) {
        return personRepository.save(s);
    }

    public Optional<Person> findById(String s) {
        return personRepository.findById(s);
    }

    public boolean existsById(String s) {
        return personRepository.existsById(s);
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

    public <S extends Person> Optional<S> findOne(Example<S> example) {
        return personRepository.findOne(example);
    }

    public <S extends Person> Page<S> findAll(Example<S> example, Pageable pageable) {
        return personRepository.findAll(example, pageable);
    }

    public <S extends Person> long count(Example<S> example) {
        return personRepository.count(example);
    }

    public <S extends Person> boolean exists(Example<S> example) {
        return personRepository.exists(example);
    }
}
