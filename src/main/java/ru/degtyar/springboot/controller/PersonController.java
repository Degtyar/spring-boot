package ru.degtyar.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.degtyar.springboot.model.Person;
import ru.degtyar.springboot.repository.PersonRepository;

import java.util.Map;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = {"/person-list"}, method = RequestMethod.GET)
    public String personList(Map<String,Object> model){
        model.put("persons", personRepository.getPerson());
        return "person-list";
    }

    @RequestMapping(value = {"/person-create"}, method = RequestMethod.GET)
    public String personCreate(){
        personRepository.merge(new Person());
        return "redirect:/person-list";
    }

    @RequestMapping(value = {"/person-remove"}, method = RequestMethod.GET)
    public String personRemove(@RequestParam("id") String personId){
        personRepository.removePersonById(personId);
        return "redirect:/person-list";
    }

    @RequestMapping(value = {"/person-edit"}, method = RequestMethod.GET)
    public String personEdit(@RequestParam("id") String personId,Map<String,Object> model){
        final Person person = personRepository.findOne(personId);
        model.put("person", person);
        return "person-edit";
    }

    @RequestMapping(value = {"/person-save"}, method = RequestMethod.POST)
    public String personSave(@ModelAttribute("person") Person person){
        personRepository.merge(person);
        return "redirect:/person-list";
    }

}
