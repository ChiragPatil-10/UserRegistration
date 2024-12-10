import java.util.Scanner;
import java.util.regex.*;
public class UserRegistration {
    public static boolean isValidFirstName(String firstName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return Pattern.matches(regex, firstName);
    }

    public static boolean isValidLastName(String lastName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return Pattern.matches(regex, lastName);
    }

    public static boolean isValidMail(String email) {
        String regex = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,}){1,2}$";
        return Pattern.matches(regex, email);
    }

    public static boolean isValidMobileNumber(String mobile) {
        String regex = "^\\d{2} \\d{10}$";
        return Pattern.matches(regex, mobile);
    }
    public static boolean isValidPassword(String password){
        String regex = "^(?=.*[A-Z]).{8,}$";
        return Pattern.matches(regex, password);
    }

    public static void main(String[] args) throws PatternSyntaxException{
        System.out.println("Welcome to User Registration Problem");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name: ");
        String firstName = sc.nextLine();
        if (isValidFirstName(firstName)) {
            System.out.println("Valid first name.");
        } else {
            System.out.println("Invalid first name. It must start with a capital letter and have at least 3 characters.");
        }
        System.out.println("Enter the Last Name");
        String lastName = sc.nextLine();
        if (isValidLastName(lastName)){
            System.out.println("Valid Last name.");
        }else {
            System.out.println("Invalid last name. It must start with a capital letter and have at least 3 characters.");
        }
        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        if (isValidMail(email)){
            System.out.println("Valid mail ID");
        }else {
            System.out.println("Invalid Mail");
        }
        System.out.println("Enter Mobile Number: format (91 84xxxxxx89)");
        String mobile = sc.nextLine();
        if (isValidMobileNumber(mobile)){
            System.out.println("Valid Mobile Number");
        }else {
            System.out.println("Invalid Mobile Number follow the format");
        }
        System.out.println("Enter Password: Minimum 8 characters with at least one uppercase");
        String password = sc.nextLine();
        if (isValidPassword(password)){
            System.out.println("Password is Valid");
        }else {
            System.out.println("Invalid Password");
        }
        sc.close();
    }
}
