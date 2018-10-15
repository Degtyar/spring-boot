package ru.degtyar.springboot.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.degtyar.springboot.model.Person;
import ru.degtyar.springboot.service.PersonService;
import ru.degtyar.springboot.soap.person.*;

import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

@Endpoint
public class PersonEndpoint {
    @NotNull
    private final static Logger LOGGER = Logger.getLogger(PersonEndpoint.class.getSimpleName());
    @NotNull
    public final static String LOCATION_URI = "/soap/person";
    @NotNull
    public final static String PORT_TYPE_NAME = "PersonEndpointPort";
    @NotNull
    public final static String NAMESPACE = "http://degtyar.ru/springboot/soap/person";

    @ResponsePayload
    @PayloadRoot(localPart = "pingRequest", namespace = NAMESPACE)
    public PingResponse ping(@RequestPayload final PingRequest request){
        final PingResponse response = new PingResponse();
        response.setSucces(true);
        return response;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "testRequest", namespace = NAMESPACE)
    public TestResponse test(@RequestPayload TestRequest request){
        return new TestResponse();
    }

    @ResponsePayload
    @PayloadRoot(localPart = "getDepartmentRequest", namespace = NAMESPACE)
    public GetPersonResponse getPerson(@RequestPayload final GetPersonRequest request){
        final GetPersonResponse response = new GetPersonResponse();
        try{
            final Iterable<Person> persons = personService.findAll();
            for(Person person: persons){
                final PersonRecord personRecord = new PersonRecord();
                personRecord.setId(person.getId());
                personRecord.setFirstName(person.getFirstName());
                personRecord.setSecondName(person.getSecondName());
                personRecord.setMiddleName(person.getMiddleName());
                personRecord.setEmail(person.getEmail());
                response.getRows().add(personRecord);
            }
        } catch(@NotNull final Exception e){
            LOGGER.severe(e.getMessage());
        }
        return response;
    }
    @ResponsePayload
    @PayloadRoot(localPart = "removeDepartmentRequest", namespace = NAMESPACE)
    public RemovePersonResponse removePerson(@RequestPayload final RemovePersonRequest request){
        final RemovePersonResponse response = new RemovePersonResponse();
        try{
            personService.deleteById(request.getId());
            response.setSucces(true);
        } catch(@NotNull final Exception e){
            response.setMessage(e.getMessage());
            response.setSucces(false);
        }
        return response;
    }
    @ResponsePayload
    @PayloadRoot(localPart = "createDepartmentRequest", namespace = NAMESPACE)
    public CreatePersonResponse createPerson(@RequestPayload final CreatePersonResponse request){
        final CreatePersonResponse response = new CreatePersonResponse();
        try{
            final Person person = new Person();
            person.setFirstName("person");
            personService.save(person);
            response.setSucces(true);
        } catch(@NotNull final Exception e){
            response.setMessage(e.getMessage());
            response.setSucces(false);
        }
        return response;
    }
    private PersonService personService;
}