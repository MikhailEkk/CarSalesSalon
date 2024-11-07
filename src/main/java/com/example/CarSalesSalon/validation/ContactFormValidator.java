package com.example.CarSalesSalon.validation;

import com.example.CarSalesSalon.model.ContactForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContactFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ContactForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContactForm form = (ContactForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Имя не может быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "Email не может быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "message.empty", "Сообщение не может быть пустым");

        if (!form.getEmail().contains("@")) {
            errors.rejectValue("email", "email.invalid", "Email должен содержать символ '@'");
        }

        if(form.getName().length() <= 1){
            errors.rejectValue("name","name.length", "Короткое имя");
        }
    }
}
