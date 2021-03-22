package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class loginPage {
    private SelenideElement username = $("#username");
    private SelenideElement password = $("#password");
    private SelenideElement rememberMe = $("#remember");
    private SelenideElement loginButton = $("#login_button");
    private SelenideElement loginButtonDomain = $("#login_button_domain");
    private SelenideElement loginButtonCurrent = $("#login_button_current");

    public void authorization(String user, String pass){
        username.should(Condition.exist)
                .sendKeys(user);
        password.should(Condition.exist)
                .sendKeys(pass);
        loginButton.should(Condition.exist)
                .click();
    }

    public void authorizationWithRemember(String user, String pass){
        username.should(Condition.exist)
                .sendKeys(user);
        password.should(Condition.exist)
                .sendKeys(pass);
        rememberMe.should(Condition.exist)
                .click();
        rememberMe.isSelected();
        loginButton.should(Condition.exist)
                .click();
    }

    public void authorizationAnyData(String user, String pass){
        username.should(Condition.exist)
                .sendKeys(user);
        password.should(Condition.exist)
                .sendKeys(pass);
        loginButtonDomain.should(Condition.exist)
                .click();
    }

    public void authorizationCurrent(String user, String pass){
        username.should(Condition.exist)
                .sendKeys(user);
        password.should(Condition.exist)
                .sendKeys(pass);
        loginButtonCurrent.should(Condition.exist)
                .click();
    }
}
