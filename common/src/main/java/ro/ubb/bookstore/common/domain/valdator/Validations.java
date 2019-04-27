package ro.ubb.bookstore.common.domain.valdator;

import java.util.ArrayList;
import java.util.List;

public class Validations
{
    private List<String> errors = new ArrayList<>();

    Validations notEmpty(String value)
    {
        if(value.length() == 0)
        {
            errors.add("can't be empty");
        }
        return this;
    }

    Validations genderInvalid(String gender)
    {
        if(!gender.equals("Male") && !gender.equals("Female"))
        {
            errors.add("invalid gender");
        }
        return this;
    }

    Validations ageInvalid(int age)
    {
        if(age <= 0)
        {
            errors.add("invalid age");
        }
        return this;
    }

    Validations idInvalid(Long id)
    {
        if(id <= 0)
        {
            errors.add("invalid id");
        }
        return this;
    }

    List<String> getErrors()
    {
        return errors;
    }
}
