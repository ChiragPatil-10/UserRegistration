import javax.naming.spi.DirObjectFactory;
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

@FunctionalInterface
interface Validator{
    boolean validate(String input);
}

public class UserRegistration {
    static Validator isValidFirstName = firstname -> {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return Pattern.matches(regex, firstname);
    };

    static Validator isValidLastName = lastname -> {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return Pattern.matches(regex, lastname);
    };

    static Validator isValidMail = mail -> {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, mail);
    };

    static Validator isValidMobileNumber = mobileNumber -> {
        String regex = "^\\d{2} \\d{10}$";
        return Pattern.matches(regex, mobileNumber);
    };

    static Validator isValidPassword = password -> {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@$%^&*?])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, password);
    };

    public static boolean MailChecker(String mail) {
        String regex = "^[a-z0-9+-]+(?:\\.[a-z0-9]+)*@[a-z0-9]+(?:\\.[a-z]{2,}){1,2}$";
        return Pattern.matches(regex, mail);
    }

    public static void main(String[] args) throws PatternSyntaxException {
        System.out.println("Welcome to User Registration Problem");
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the First Name: ");
        String firstName = sc.nextLine();
        if (isValidFirstName.validate(firstName)){
            System.out.println("Valid first name.");
        } else {
            System.out.println("Invalid first name. It must start with a capital letter and have at least 3 characters.");
        }


        System.out.println("Enter the Last Name");
        String lastName = sc.nextLine();
        if (isValidLastName.validate(lastName)){
            System.out.println("Valid Last name.");
        }else {
            System.out.println("Invalid last name. It must start with a capital letter and have at least 3 characters.");
        }


        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        if (isValidMail.validate(email)){
            System.out.println("Valid mail ID");
        }else {
            System.out.println("Invalid Mail.");
        }


        System.out.println("Enter Mobile Number: format (91 95xxxxxx62)");
        String mobile = sc.nextLine();
        if (isValidMobileNumber.validate(mobile)){
            System.out.println("Valid Mobile Number");
        }else {
            System.out.println("Invalid Mobile Number. Follow the format.");
        }


        System.out.println("Enter Password: Minimum 8 characters with at least one uppercase and at least one numeric number");
        String password = sc.nextLine();
        if (isValidPassword.validate(password)){
            System.out.println("Password is Valid");
        }else {
            System.out.println("Invalid Password.");
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