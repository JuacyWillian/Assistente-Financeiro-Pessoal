package afp.util;

public class Validator {

    public static boolean validateEmail(String email) {
        String regex = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-.]+)+$)";
        return email.matches(regex);
    }
}
