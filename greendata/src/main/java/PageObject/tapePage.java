package PageObject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class tapePage {
    private SelenideElement userMenu = $("span.icon-user_menu");
    private ElementsCollection userMenuDrop = $$("ul.list-unstyled li");

    public void deauthorization(){
        userMenu.should(Condition.exist)
                .click();
        userMenuDrop.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .findBy(Condition.text("Выход"))
                .click();
    }
}
