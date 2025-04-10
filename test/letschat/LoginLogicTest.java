package letschat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginLogicTest {

    @Test
    public void testLoginSuccessful() {
        AccountCreate account = new AccountCreate();
        account.processAccountCreation("kyl_1", "Ch&&sec@ke99!", "Ch&&sec@ke99!", "+27838968976");

        LoginLogic login = new LoginLogic();
        boolean loginResult = login.processLogin("kyl_1", "Ch&&sec@ke99!", account);

        assertTrue(loginResult);
    }

    @Test
    public void testLoginFailedIncorrectPassword() {
        AccountCreate account = new AccountCreate();
        account.processAccountCreation("kyl_1", "Ch&&sec@ke99!", "Ch&&sec@ke99!", "+27838968976");

        LoginLogic login = new LoginLogic();
        boolean loginResult = login.processLogin("kyl_1", "WrongPass123!", account);

        assertFalse(loginResult);
    }

    @Test
    public void testLoginFailedIncorrectUsername() {
        AccountCreate account = new AccountCreate();
        account.processAccountCreation("kyl_1", "Ch&&sec@ke99!", "Ch&&sec@ke99!", "+27838968976");

        LoginLogic login = new LoginLogic();
        boolean loginResult = login.processLogin("wrong_user", "Ch&&sec@ke99!", account);

        assertFalse(loginResult);
    }

    @Test
    public void testLoginMaxAttemptsReached() {
        AccountCreate account = new AccountCreate();
        account.processAccountCreation("kyl_1", "Ch&&sec@ke99!", "Ch&&sec@ke99!", "+27838968976");

        LoginLogic login = new LoginLogic();

        // 3 failed attempts
        login.processLogin("kyl_1", "wrong1", account);
        login.processLogin("kyl_1", "wrong2", account);
        login.processLogin("kyl_1", "wrong3", account);

        // Should be locked out now
        boolean loginResult = login.processLogin("kyl_1", "Ch&&sec@ke99!", account);

        assertFalse(loginResult);
    }
}
