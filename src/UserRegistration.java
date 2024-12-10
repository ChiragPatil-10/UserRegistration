import java.util.Scanner;

public class UserRegistration {

    private static boolean isValidFirstName(String name) {

        return name.matches("[A-Z][a-z]{2,}");
    }


    public static void main(String[] args) {
        System.out.println("Welcome to the User Registration Program");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First name: ");
        String firstName = sc.nextLine();

        if(isValidFirstName(firstName)) {
            System.out.println("First name is Valid!!");
        } else {
            System.out.println("Please enter a valid First name starting with Cap and has minimum 3 characters");
        }
    }

}
