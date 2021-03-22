package dirvers;

import com.codeborne.selenide.WebDriverRunner;

/**
 * Создание и закрытие экземпляра драйвера.
 */
public class tear {

    /**
     * Создаем экземпляр нужного драйвера для селенида
     */
    public void tearUp(){
        WebDriverRunner.setWebDriver(driversEnum.CHROME.create());
    }

    /**
     * Получаем экземпляр драйвера селенида, если он есть - закрываем его
     */
    public void tearDown(){
        if(WebDriverRunner.getWebDriver() != null){
            WebDriverRunner.getWebDriver().quit();
        }
    }

}
