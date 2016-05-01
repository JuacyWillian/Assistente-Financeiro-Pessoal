package afp.utils;

public class Validator {

    public static boolean validateEmail(String email) {
        String regex = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-.]+)+$)";
        return email.matches(regex);
    }

    public static boolean validateCPF(String cpf) {
        String regex = "(^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$)";
        return cpf.matches(regex);
    }
}
