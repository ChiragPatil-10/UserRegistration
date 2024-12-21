import java.util.Scanner;
import java.util.regex.*;

class InvalidFirstNameException extends Exception{
    public InvalidFirstNameException(String message){
        super(message);
    }
}

class InvalidLastNameException extends Exception{
    public InvalidLastNameException(String message){
        super(message);
    }
}

class InvalidMailException extends Exception{
    public InvalidMailException(String message){
        super(message);
    }
}

class InvalidMobileException extends Exception{
    public InvalidMobileException(String message){
        super(message);
    }
}

class InvalidPasswordException extends Exception{
    public InvalidPasswordException(String message){
        super(message);
    }
}
public class UserRegistration {
    public static void isValidFirstName(String firstName) throws InvalidFirstNameException {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        if (!Pattern.matches(regex, firstName)) {
            throw new InvalidFirstNameException("Invalid first name. It must start with a capital letter and have at least 3 characters.");
        }
    }

    public static void isValidLastName(String lastName) throws InvalidLastNameException {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        if (!Pattern.matches(regex, lastName)) {
            throw new InvalidLastNameException("Invalid last name. It must start with a capital letter and have at least 3 characters.");
        }
    }

    public static void isValidMail(String email) throws InvalidMailException {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!Pattern.matches(regex, email)) {
            throw new InvalidMailException("Invalid email format.");
        }
    }

    public static void isValidMobileNumber(String mobile) throws InvalidMobileException {
        String regex = "^\\d{2} \\d{10}$";
        if (!Pattern.matches(regex, mobile)){
            throw new InvalidMobileException("Invalid mobile number. Follow the format (91 84xxxxxx89).");
        }
    }

    public static void isValidPassword(String password) throws InvalidPasswordException {
        String regex = "^[A-Z][A-Za-z\\d@$!%*?&]{8,}$";
        if (!Pattern.matches(regex, password)){
            throw new InvalidPasswordException("Invalid password. Minimum 8 characters with at least one uppercase and at least one numeric number.");
        }
    }

    public static boolean MailChecker(String mail) {
        String regex = "^[a-z0-9+-]+(?:\\.[a-z0-9]+)*@[a-z0-9]+(?:\\.[a-z]{2,}){1,2}$";
        return Pattern.matches(regex, mail);
    }

    public static void main(String[] args) throws PatternSyntaxException {
        System.out.println("Welcome to User Registration Problem");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the First Name: ");
            String firstName = sc.nextLine();
            isValidFirstName(firstName);
            System.out.println("Valid first name.");
        } catch (InvalidFirstNameException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Enter the Last Name");
            String lastName = sc.nextLine();
            isValidLastName(lastName);
            System.out.println("Valid Last name.");
        } catch (InvalidLastNameException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Enter Email: ");
            String email = sc.nextLine();
            isValidMail(email);
            System.out.println("Valid mail ID");
        }catch (InvalidMailException e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Enter Mobile Number: format (91 95xxxxxx62)");
            String mobile = sc.nextLine();
            isValidMobileNumber(mobile);
            System.out.println("Valid Mobile Number");
        }catch (InvalidMobileException e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Enter Password: Minimum 8 characters with at least one uppercase and at least one numeric number");
            String password = sc.nextLine();
            isValidPassword(password);
            System.out.println("Password is Valid");
        }catch (InvalidPasswordException e){
            System.out.println(e.getMessage());
        }

        sc.close();
        String[] invalidEmails = {"abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com", ".abc@abc.com", "abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com", "abc.@gmail.com", "abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au"};
        for (String e : invalidEmails) {
            System.out.println(e + " is " + (MailChecker(e) ? "Correct Format" : "Incorrect Format"));
        }
        String[] validEmails = {"abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com", "abc-100@abc.net", "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com"};
        for (String e : validEmails) {
            System.out.println(e + " is " + (MailChecker(e) ? "Correct Format" : "Invalid Format"));
        }
    }
}