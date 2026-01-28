package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

/**
 * Класс для параллельного запуска теста fillManyTextSelenideBoxes 100 раз с использованием Selenoid
 */
public class SelenideTestsParallel {
    
    @BeforeClass
    public void setUp() {
        // флаг headless для Selenide (по умолчанию true)
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        // Настройка для работы с Selenoid
        String selenoidUrl = System.getProperty("selenoid.url", "http://selenoid.autotests.cloud:4444/wd/hub");
        Configuration.remote = selenoidUrl;
        Configuration.browser = "chrome";
        String browserVersion = System.getProperty("browser.version", "latest");
        Configuration.timeout = 20000;
        Configuration.headless = headless;

        // Настройки для Selenoid через DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", browserVersion);
        capabilities.setCapability("enableVNC", false);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("enableLog", true);
        capabilities.setCapability("screenResolution", "1920x1080x24");

        Configuration.browserCapabilities = capabilities;
    }

    @Test(invocationCount = 100, threadPoolSize = 5, description = "Запуск fillManyTextSelenideBoxes 100 раз в 5 потоков через Selenoid")
    public void fillManyTextSelenideBoxes(){
        open("https://datatables.net/examples/api/form.html");
        $x("//select[@class='dt-input']").selectOption("50");
        ElementsCollection textFields = $$x("//tbody//input[@type='text']");
        textFields.asFixedIterable().forEach(x->{
            x.clear();
            x.sendKeys("threadqa selenide");
        });
    }
}
