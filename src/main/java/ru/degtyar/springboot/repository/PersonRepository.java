package ru.degtyar.springboot.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.degtyar.springboot.model.Person;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface PersonRepository extends PagingAndSortingRepository<Person, String>{

}
