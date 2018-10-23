package ru.degtyar.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.degtyar.springboot.model.Person;
import ru.degtyar.springboot.repository.PersonRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class PersonTest {

    @Autowired
    private PersonRepository personRepository;
    final Person person = new Person("Волков","Владимир","Петрович","volkov@example.com");


    @Test
    public void testPersonCRUD(){
        personRepository.merge(person);
        Assert.assertEquals(personRepository.personFindByFirstName(person.getFirstName()).getId(),person.getId());
        Assert.assertNotNull(personRepository.findOne(person.getId()));
        personRepository.removePersonById(person.getId());
        Assert.assertEquals(personRepository.personFindByFirstName(person.getId()),null);
        Assert.assertEquals(personRepository.getPerson().size(),2);
    }
}
