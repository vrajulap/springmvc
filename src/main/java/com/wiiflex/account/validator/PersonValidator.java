package com.wiiflex.account.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wiiflex.account.model.Person;

@Component
public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return Person.class.equals(aClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Person person = (Person) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty");
	}
}
