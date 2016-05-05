package afp.util;

import afp.util.Validator;
import junit.framework.TestCase;

public class ValidatorTest extends TestCase {

    @Override
    public void setUp() {
    }

    public void test_validateEmail_is_true() {
        String email = "juacy.willian@gmail.com";
        assertEquals(true, Validator.validateEmail(email));
    }

    public void test_validate_is_false() {
        String email = "juacy.williangmail.com";
        assertEquals(false, Validator.validateEmail(email));
    }
}
