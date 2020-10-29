package com.wiiflex.account.service;

import java.util.List;

import com.wiiflex.account.model.Person;

public interface PersonService {

	void addPerson(Person p);

	void updatePerson(Person p);

	void removePerson(Long id);

	Person getPersonById(Long id);

	List<Person> listPersons();
}
