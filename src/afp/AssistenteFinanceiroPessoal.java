package afp;

import afp.services.UserService;

public class AssistenteFinanceiroPessoal {

    private static AssistenteFinanceiroPessoal instance;

    private AssistenteFinanceiroPessoal() {
    }

    public static AssistenteFinanceiroPessoal getInstance() {
        if (instance == null) {
            instance = new AssistenteFinanceiroPessoal();
        }
        return instance;
    }

    public UserService createUser(String nome, String email, String password) {
        return null;
    }

    public static void main(String[] args) {
        AssistenteFinanceiroPessoal app = getInstance();

        System.out.println(app.createUser("Juacy Willian", "juacy.willian@gmail.com", "Stella.2010"));
        System.out.println(app.login("Juacy Willian", "juacy.willian@gmail.com", "Stella.2010"));
    }

    public boolean login(String juacy_Willian, String juacywilliangmailcom, String stella2010) {
        return false;
    }
}
