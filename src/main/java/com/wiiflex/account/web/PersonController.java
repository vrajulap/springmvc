package com.wiiflex.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wiiflex.account.model.Person;
import com.wiiflex.account.service.PersonService;
import com.wiiflex.account.validator.PersonValidator;
import com.wiiflex.account.validator.UserValidator;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonValidator personValidator;

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}

	// For add and update person both
	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
		
		personValidator.validate(person, bindingResult);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("listPersons", this.personService.listPersons());
			return "person";
		}

		if (person.getId() == null || person.getId() == 0) {
			// new person, add it
			this.personService.addPerson(person);
		} else {
			// existing person, call update
			this.personService.updatePerson(person);
		}

		return "redirect:/persons";

	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") long id) {
		this.personService.removePerson(id);
		return "redirect:/persons";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", this.personService.getPersonById(id));
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}

}
