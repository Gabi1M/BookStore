package ro.ubb.bookstore.common.domain.valdator;

import ro.ubb.bookstore.common.domain.Client;
import java.util.List;

public class ClientValidator implements Validator<Client>
{
    @Override
    public void validate(Client client) throws ValidatorException
    {
        List<String> errors = new Validations().notEmpty(client.getName()).notEmpty(client.getName()).notEmpty(client.getName()).genderInvalid(client.getGender()).ageInvalid(client.getAge()).idInvalid(client.getId()).getErrors();
        if(!errors.isEmpty())
        {
            throw new ValidatorException(errors.toString());
        }
    }
}
