package afp.utils;

import junit.framework.TestCase;


public class ValidatorTest extends TestCase{
    
    @Override
    public void setUp() {
    }

    public void test_validateEmail_is_true() {
        String email = "juacy.willian@gmail.com";
        assertEquals(true, Validator.validateEmail(email));
    }

    public void test_validateCPF_is_true() {
        String cpf = "123.456.789-00";
        assertEquals(true, Validator.validateCPF(cpf));
    }

    public void test_validate_is_false() {
        String email = "juacy.williangmail.com";
        assertEquals(false, Validator.validateEmail(email));
    }

    public void test_validateCPF_is_false() {
        String cpf = "12345678900";
        assertEquals(false, Validator.validateCPF(cpf));
    }
    
}
