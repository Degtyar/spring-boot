package ru.degtyar.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.degtyar.springboot.model.Person;
import ru.degtyar.springboot.service.PersonService;

import java.util.Map;
import java.util.Optional;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = {"/person-list"}, method = RequestMethod.GET)
    public String personList(Map<String,Object> model){
        model.put("persons", personService.findAll());
        return "person-list";
    }

    @RequestMapping(value = {"/person-create"}, method = RequestMethod.GET)
    public String personCreate(){
        personService.save(new Person());
        return "redirect:/person-list";
    }

    @RequestMapping(value = {"/person-remove"}, method = RequestMethod.GET)
    public String personRemove(@RequestParam("id") String personId){
        personService.deleteById(personId);
        return "redirect:/person-list";
    }

    @RequestMapping(value = {"/person-edit"}, method = RequestMethod.GET)
    public String personEdit(@RequestParam("id") String personId,Map<String,Object> model){
        final Optional<Person> person = personService.findById(personId);
        model.put("person", person);
        return "person-edit";
    }

    @RequestMapping(value = {"/person-save"}, method = RequestMethod.POST)
    public String personSave(@ModelAttribute("person") Person person){
        personService.save(person);
        return "redirect:/person-list";
    }

}
