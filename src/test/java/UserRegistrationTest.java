import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    @Test
    public void isValidFirstName_HappyCase() {
        assertTrue(UserRegistration.isValidFirstName("Chirag"));
    }

    @Test
    public void isValidFirstName_SadCase() {
        assertFalse(UserRegistration.isValidFirstName("tony"));
        assertFalse(UserRegistration.isValidFirstName("ton"));
        assertFalse(UserRegistration.isValidFirstName("t"));
    }

    @Test
    public void isValidLastName_HappyCase() {
        assertTrue(UserRegistration.isValidLastName("Patil"));
    }

    @Test
    public void isValidLastName_SadCase() {
        assertFalse(UserRegistration.isValidLastName("pat"));
        assertFalse(UserRegistration.isValidLastName("p"));
        assertFalse(UserRegistration.isValidLastName("patil"));
    }

    @Test
    public void isValidMail_HappyCase() {
        assertTrue(UserRegistration.isValidMail("patilchirag192k@gmail.com"));
    }

    @Test
    public void isValidMail_SadCase() {
        assertFalse(UserRegistration.isValidMail("pat@b1"));
        assertFalse(UserRegistration.isValidMail("abc.xyz@.com"));
        assertFalse(UserRegistration.isValidMail("abc.xyz@bl@co.in"));
    }

    @Test
    public void isValidMobileNumber_HappyCase() {
        assertTrue(UserRegistration.isValidMobileNumber("91 9579588662"));
    }

    @Test
    public void isValidMobileNumber_SadCase() {
        assertFalse(UserRegistration.isValidMobileNumber("9195795886622"));
        assertFalse(UserRegistration.isValidMobileNumber("91-957958862"));
        assertFalse(UserRegistration.isValidMobileNumber("91 95795"));
    }

    @Test
    public void isValidPassword_HappyCase() {

        assertTrue(UserRegistration.isValidPassword("Dracarys@123"));
    }
    @Test
    public void isValidPassword_SadCase() {
        assertFalse(UserRegistration.isValidPassword("dracarys@1"));
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
