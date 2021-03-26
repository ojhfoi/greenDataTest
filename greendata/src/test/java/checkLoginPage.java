import PageObject.loginPage;
import com.codeborne.selenide.Condition;
import dirvers.tear;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class checkLoginPage {

    tear tear = new tear();
    loginPage loginPage = new loginPage();

    @Test
    @Parameters({"user", "pass"})
    public void check(String user, String pass){
        try {
            tear.tearUp();
            open("https://gdcloud.ru/release-17/auth/login");
            loginPage.authorization(user, pass);
            $("span#userName")
                    .should(Condition.exist, Duration.ofSeconds(10))
                    .getText()
                    .contains("Фамилия И.О");
        }catch (Throwable t){
            Assert.fail("login error", t.fillInStackTrace());
        }finally {
            tear.tearDown();
        }
    }

}
