class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
}

class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class Validator {

    public static void validateUsername(String username) throws InvalidUserException {
        if (username == null || username.length() < 5) {
            throw new InvalidUserException("Username must contain at least 5 characters");
        }
    }

    public static void validateAge(int age) {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void validateEmail(String email) throws InvalidUserException {
        if (!email.contains("@") || !email.contains(".")) {
            throw new InvalidUserException("Invalid email format");
        }
    }
}

public class problem3 {

    public static void main(String[] args) {

        String username = "Sathwik";
        int age = 17;
        String email = "sathwikgmail.com";

        try {
            Validator.validateUsername(username);
            Validator.validateAge(age);
            Validator.validateEmail(email);

            System.out.println("All validations passed");

        } catch (InvalidUserException e) {
            System.out.println("User validation error: " + e.getMessage());

        } catch (InvalidAgeException e) {
            System.out.println("Age validation error: " + e.getMessage());

        } finally {
            System.out.println("Validation process completed");
        }
    }
}
