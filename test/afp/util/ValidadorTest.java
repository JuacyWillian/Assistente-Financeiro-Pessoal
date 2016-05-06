package afp.util;

import afp.util.Validador;
import junit.framework.TestCase;

public class ValidadorTest extends TestCase {

    @Override
    public void setUp() {
    }

    public void test_validateEmail_is_true() {
        String email = "juacy.willian@gmail.com";
        assertEquals(true, Validador.validateEmail(email));
    }

    public void test_validate_is_false() {
        String email = "juacy.williangmail.com";
        assertEquals(false, Validador.validateEmail(email));
    }
}
