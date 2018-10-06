package ru.degtyar.springboot.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import ru.degtyar.springboot.model.Person;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PersonRepository {

    private Map<String,Person> persons = new LinkedHashMap<>();

    public void merge(@Nullable final Person person){
        if(person == null) return;
        if(person.getId() == null || person.getId().isEmpty()) return;
        persons.put(person.getId(),person);
    }

    @NonNull
    public Collection<Person> getPerson(){
        return persons.values();
    }

    @PostConstruct
    public void init(){
        merge(new Person("Петров","Петр","Петрович","petrov@example.com"));
        merge(new Person("Васильев","Василий","Васильевич","vasilev@example.com"));
    }

    public Person findOne (final String personId){
        if (personId == null || personId.isEmpty()) return null;
        return persons.get(personId);
    }

    public void removePersonById(final String personId){
        if (personId == null || personId.isEmpty()) return;
        persons.remove(personId);
    }
}
