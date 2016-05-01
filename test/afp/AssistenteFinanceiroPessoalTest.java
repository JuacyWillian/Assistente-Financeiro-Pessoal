package afp;

import junit.framework.TestCase;

public class AssistenteFinanceiroPessoalTest extends TestCase {

    AssistenteFinanceiroPessoal app;

    @Override
    public void setUp() {
        app = AssistenteFinanceiroPessoal.getInstance();
    }

    public void test_login_is_true() {
        assertTrue("esterado True", app.login("nome", "email", "senha"));
    }

    public void test_createUser_is_not_null() {
        assertNotNull(app.createUser("nome", "email", "senha"));
    }
}
