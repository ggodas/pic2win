package br.com.cupomclick.model.validator;

import br.com.cupomclick.model.customer.CustomerCreateDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by georgegodas on 21/09/16.
 */
@Component
public class CustomerCreateValidator implements Validator {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> aClass) {
        return CustomerCreateDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");
        ValidationUtils.rejectIfEmpty(errors, "documentId", "documentId.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email");

        CustomerCreateDTO customer = (CustomerCreateDTO) o;

        if(customer.getBirthdayDate() == null){
            errors.rejectValue("birthdayDate", "birthdayDate.empty");
        }

        if(customer.getPassword().length() < 6 || customer.getPassword().length() > 10){
            errors.rejectValue("password", "password.size");
        }

        if (customer.getEmail() != null && !customer.getEmail().isEmpty()) {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(customer.getEmail());
            if (!matcher.matches()) {
                errors.rejectValue("email", "email.incorrect");
            }
        }


    }
}

