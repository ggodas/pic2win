package br.com.pic2win.model.validator;

import br.com.pic2win.model.customer.CustomerCreateDTO;
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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email");

        CustomerCreateDTO customer = (CustomerCreateDTO) o;

        if (customer.getEmail() != null && !customer.getEmail().isEmpty()) {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(customer.getEmail());
            if (!matcher.matches()) {
                errors.rejectValue("email", "email.incorrect");
            }
        }


    }
}

