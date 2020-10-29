package com.wiiflex.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiiflex.account.model.Person;
import com.wiiflex.account.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	@Transactional
	public void addPerson(Person person) {
		personRepository.save(person);

	}

	
	@Override
	@Transactional
	public void updatePerson(Person person) {
		personRepository.save(person);

	}

	
	@Override
	@Transactional
	public void removePerson(Long id) {
		personRepository.delete(id);
	}

	
	@Override
	@Transactional(readOnly = true)
	public Person getPersonById(Long id) {
		return personRepository.getOne(id);
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Person> listPersons() {
		return personRepository.findAll();
	}

}
