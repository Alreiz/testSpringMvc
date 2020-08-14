package ru.mutagarov.eduard;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mutagarov.eduard.model.Person;
import ru.mutagarov.eduard.model.PersonDataService;

import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class MvcController {

    final PersonDataService personDataService;

    public MvcController(PersonDataService personDataService) {
        this.personDataService = personDataService;
    }


    @RequestMapping("/")
    public ModelAndView home() {
        List<Person> listPerson = personDataService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listPerson", listPerson);
        return mav;
    }

    @RequestMapping("/newPerson")
    public String newPerson(Map<String,Object> model) {
        Person person = new Person();
        model.put("person", person);
        return "newPerson";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("person") Person person) {
        personDataService.save(person);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_person");
        Person person = personDataService.get(id);
        mav.addObject("person", person);
        return mav;
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        personDataService.delete(id);
        return "redirect:/";
    }
}
