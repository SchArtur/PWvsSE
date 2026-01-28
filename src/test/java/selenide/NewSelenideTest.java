package selenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NewSelenideTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 20000;
    }

    @Test
    public void newSelenideTest() {
        open("https://schneider-russia.com");
        $x("//a[text()='Розетки']").shouldBe(visible).click();
        $x("//a[text()='USB-розетки']").shouldBe(visible).click();
        $x("//*[@class='category-item-title'][1]").shouldBe(visible).click();
        $x("//*[@class='e-icon-catalog-w']/span").hover();
        $x("//*[@data-buytext]").shouldBe(visible).hover().click();
        $x("//a[contains(text(), 'Перейти в корзину')]").shouldBe(visible).click();
        executeJavaScript("window.scrollTo(0,184)");
        $x("//*[contains(@class, 'btn-count') and contains(@class, 'btn-plus')]").shouldBe(visible).click();
        $x("//*[contains(@class, 'btn-delete-item')]").shouldBe(visible).click();
    }
}
