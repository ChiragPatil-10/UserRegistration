import java.util.Scanner;
import java.util.regex.*;

public class UserRegistration {
    public static boolean isValidFirstName(String firstName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return Pattern.matches(regex, firstName);
    }
    public static boolean isValidLastName(String lastName){
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return Pattern.matches(regex, lastName);
    }

    public static void main(String[] args) {
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

    }
}