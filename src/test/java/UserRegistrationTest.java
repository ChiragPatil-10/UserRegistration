import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    @Test
    public void isValidFirstName_HappyCase() throws InvalidFirstNameException {
        UserRegistration.isValidFirstName("Chirag");
    }

    @Test
    public void isValidFirstName_SadCase()  {
        assertThrows(InvalidFirstNameException.class, () -> UserRegistration.isValidFirstName("tony"));
        assertThrows(InvalidFirstNameException.class, () -> UserRegistration.isValidFirstName("ton"));
        assertThrows(InvalidFirstNameException.class, () -> UserRegistration.isValidFirstName("t"));
    }

    @Test
    public void isValidLastName_HappyCase() throws InvalidLastNameException {
        UserRegistration.isValidLastName("Patil");
    }

    @Test
    public void isValidLastName_SadCase() {
        assertThrows(InvalidLastNameException.class, () -> UserRegistration.isValidLastName("pa"));
        assertThrows(InvalidLastNameException.class, () -> UserRegistration.isValidLastName("P"));
        assertThrows(InvalidLastNameException.class, () -> UserRegistration.isValidLastName("patil"));
    }

    @Test
    public void isValidMail_HappyCase() throws InvalidMailException {
        UserRegistration.isValidMail("patilchirag192k@gmail.com");
    }

    @Test
    public void isValidMail_SadCase()  {
        assertThrows(InvalidMailException.class, () -> UserRegistration.isValidMail("pat@b1"));
        assertThrows(InvalidMailException.class, () -> UserRegistration.isValidMail("pat.xyz@.com"));
        assertThrows(InvalidMailException.class, () -> UserRegistration.isValidMail("patil.xyz@bl@com.in"));
    }

    @Test
    public void isValidMobileNumber_HappyCase() throws InvalidMobileException {
        UserRegistration.isValidMobileNumber("91 9579588662");
    }

    @Test
    public void isValidMobileNumber_SadCase() {
        assertThrows(InvalidMobileException.class, () -> UserRegistration.isValidMobileNumber("9195795886622"));
        assertThrows(InvalidMobileException.class, () -> UserRegistration.isValidMobileNumber("91-957958862"));
        assertThrows(InvalidMobileException.class, () -> UserRegistration.isValidMobileNumber("91 95795"));
    }

    @Test
    public void isValidPassword_HappyCase() throws InvalidPasswordException {
        UserRegistration.isValidPassword("Dracarys@123");
    }

    @Test
    public void isValidPassword_SadCase() {
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("dracarys@1"));
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("draca@"));
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("dracs1"));
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("dracary"));
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("drac@1"));
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