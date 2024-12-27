import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    @Test
    public void isValidFirstName_HappyCase(){
        UserRegistration.isValidFirstName.validate("Chirag");
    }

    @Test
    public void isValidFirstName_SadCase() {
        assertThrows(InvalidFirstNameException.class, () -> {
            if (!UserRegistration.isValidFirstName.validate("tony")) throw new InvalidFirstNameException("Invalid first name.");
        });
        assertThrows(InvalidFirstNameException.class, () -> {
            if (!UserRegistration.isValidFirstName.validate("ton")) throw new InvalidFirstNameException("Invalid first name.");
        });
        assertThrows(InvalidFirstNameException.class, () -> {
            if (!UserRegistration.isValidFirstName.validate("T")) throw new InvalidFirstNameException("Invalid first name.");
        });
    }

    @Test
    public void isValidLastName_HappyCase(){
        UserRegistration.isValidLastName.validate("Patil");
    }

    @Test
    public void isValidLastName_SadCase() {
        assertThrows(InvalidLastNameException.class, () -> {
            if (!UserRegistration.isValidLastName.validate("pat")) throw new InvalidLastNameException("Invalid last name.");
        });
        assertThrows(InvalidLastNameException.class, () -> {
            if (!UserRegistration.isValidLastName.validate("P")) throw new InvalidLastNameException("Invalid last name.");
        });
        assertThrows(InvalidLastNameException.class, () -> {
            if (!UserRegistration.isValidLastName.validate("patil")) throw new InvalidLastNameException("Invalid last name.");
        });
    }

    @Test
    public void isValidMail_HappyCase(){
        UserRegistration.isValidMail.validate("abc.xyz@bl.co.in");
    }

    @Test
    public void isValidMail_SadCase() {
        assertThrows(InvalidMailException.class, () -> {
            if (!UserRegistration.isValidMail.validate("abc@b1")) throw new InvalidMailException("Invalid email.");
        });
        assertThrows(InvalidMailException.class, () -> {
            if (!UserRegistration.isValidMail.validate("abc.xyz@.com")) throw new InvalidMailException("Invalid email.");
        });
        assertThrows(InvalidMailException.class, () -> {
            if (!UserRegistration.isValidMail.validate("abc.xyz@bl@co.in")) throw new InvalidMailException("Invalid eamil.");
        });
    }

    @Test
    public void isValidMobileNumber_HappyCase(){
        UserRegistration.isValidMobileNumber.validate("91 9579588662");
    }

    @Test
    public void isValidMobileNumber_SadCase() {
        assertThrows(InvalidMobileException.class, () -> {
            if (!UserRegistration.isValidMobileNumber.validate("919579588662")) throw new InvalidMobileException("Invalid mobile number.");
        });
        assertThrows(InvalidMobileException.class, () -> {
            if (!UserRegistration.isValidMobileNumber.validate("91-9579588662")) throw new InvalidMobileException("Invalid mobile number.");
        });
        assertThrows(InvalidMobileException.class, () -> {
            if (!UserRegistration.isValidMobileNumber.validate("91 95795")) throw new InvalidMobileException("Invalid mobile number.");
        });
    }

    @Test
    public void isValidPassword_HappyCase(){
        UserRegistration.isValidPassword.validate("Dracarys@12");
    }

    @Test
    public void isValidPassword_SadCase() {
        assertThrows(InvalidPasswordException.class, () -> {
            if (!UserRegistration.isValidPassword.validate("darcarys@1")) {
                throw new InvalidPasswordException("Invalid Password.");
            }
        });
        assertThrows(InvalidPasswordException.class, () -> {
            if (!UserRegistration.isValidPassword.validate("Dracarys@")) {
                throw new InvalidPasswordException("Invalid Password.");
            }
        });
        assertThrows(InvalidPasswordException.class, () -> {
            if (!UserRegistration.isValidPassword.validate("Dracarys1")) {
                throw new InvalidPasswordException("Invalid Password.");
            }
        });
        assertThrows(InvalidPasswordException.class, () -> {
            if (!UserRegistration.isValidPassword.validate("Dracarys")) {
                throw new InvalidPasswordException("Invalid Password.");
            }
        });
        assertThrows(InvalidPasswordException.class, () -> {
            if (!UserRegistration.isValidPassword.validate("Drac@1")) {
                throw new InvalidPasswordException("Invalid Password.");
            }
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc+100@gmail.com",
            "abc-100@abc.net",
            "abc-100@yahoo.com",
            "abc.100@abc.com.au",
            "abc.100@yahoo.com",
            "abc111@abc.com",
            "abc@1.com",
            "abc@gmail.com.com",
            "abc@yahoo.com"
    })
    void testValidEmails(String email){
        assertTrue(UserRegistration.MailChecker(email), "Email should be valid: "+email);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "abc@.com.my",
            "abc123@gmail.a",
            "abc123@.com",
            "abc123@.com.com",
            ".abc@abc.com",
            "abc()*@gmail.com",
            "abc@%*.com",
            "abc..2002@gmail.com",
            "abc.@gmail.com",
            "abc@abc@gmail.com",
            "abc@gmail.com.1a",
            "abc@gmail.com.aa.au"
    })
    void testInValidEmails(String email){
        assertFalse(UserRegistration.MailChecker(email), "Email are Invalid: "+email);
    }
}