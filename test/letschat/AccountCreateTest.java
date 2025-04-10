package letschat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountCreateTest {

    @Test
    public void testUsernameCorrectlyFormatted() {
        AccountCreate account = new AccountCreate();
        boolean result = account.processAccountCreation("kyl_1", "Ch&&sec@ke99!", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(result);
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        AccountCreate account = new AccountCreate();
        boolean result = account.processAccountCreation("kyle!!!!!!!", "Ch&&sec@ke99!", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(result);
    }

    @Test
    public void testPasswordMeetsComplexity() {
        AccountCreate account = new AccountCreate();
        boolean result = account.processAccountCreation("user_", "Ch&&sec@ke99!", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(result);
    }

    @Test
    public void testPasswordFailsComplexity() {
        AccountCreate account = new AccountCreate();
        boolean result = account.processAccountCreation("user_", "password", "password", "+27838968976");
        assertFalse(result);
    }

    @Test
    public void testPhoneNumberCorrectFormat() {
        AccountCreate account = new AccountCreate();
        boolean result = account.processAccountCreation("user_", "Ch&&sec@ke99!", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(result);
    }

    @Test
    public void testPhoneNumberIncorrectFormat() {
        AccountCreate account = new AccountCreate();
        boolean result = account.processAccountCreation("user_", "Ch&&sec@ke99!", "Ch&&sec@ke99!", "08966553");
        assertFalse(result);
    }
}
