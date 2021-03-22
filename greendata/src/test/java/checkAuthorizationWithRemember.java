import PageObject.loginPage;
import PageObject.tapePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import dirvers.tear;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class checkAuthorizationWithRemember {

    dirvers.tear tear = new tear();
    PageObject.loginPage loginPage = new loginPage();
    tapePage tapePage = new tapePage();

    @Ignore
    @Test
    @Parameters({"user", "pass"})
    public void check(String user, String pass){
        try {
            tear.tearUp();
            open("https://gdcloud.ru/release-17/auth/login");
            loginPage.authorizationWithRemember(user, pass);
            $("span#userName")
                    .should(Condition.exist, Duration.ofSeconds(10))
                    .getText()
                    .contains("Фамилия И.О");
//            tapePage.deauthorization();
            Selenide.closeWindow();
            open("https://gdcloud.ru/release-17/auth/login");
            $("#login_button_current").should(Condition.exist)
                    .click();
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
