package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Базовый класс для тестов на Selenium WebDriver
 */
public class SeleniumBaseTest {
    protected WebDriver driver;

    /**
     * Инициализация WebDriver перед запуском всех тестов в классе
     */
    @BeforeClass
    public void setUp() {
        // Автоматическая настройка ChromeDriver через WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Настройка опций Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // Раскомментируйте для headless режима:
        // options.addArguments("--headless");
        
        // Создание экземпляра WebDriver
        driver = new ChromeDriver(options);
    }

    /**
     * Закрывает браузер после выполнения всех тестов в классе
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
