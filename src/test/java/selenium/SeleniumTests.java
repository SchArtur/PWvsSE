package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Примеры тестов на Selenium WebDriver
 */
public class SeleniumTests extends SeleniumBaseTest {

    @Test
    public void textBoxFillSeleniumTest() {
        driver.get("http://85.192.34.140:8081/");
        
        // Клик по элементу "Elements"
        driver.findElement(By.xpath("//*[text()='Elements']")).click();
        
        // Клик по "Text Box"
        driver.findElement(By.xpath("//li[@id='item-0']/span[1]")).click();
        
        // Заполнение полей формы
        driver.findElement(By.id("userName")).sendKeys("ThreadQA Test");
        driver.findElement(By.id("userEmail")).sendKeys("threadqa@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("somewhere");
        
        // Отправка формы
        driver.findElement(By.id("submit")).click();
        
        // Проверки
        WebElement output = driver.findElement(By.id("output"));
        Assert.assertTrue(output.isDisplayed(), "Output блок должен быть видимым");
        
        WebElement nameElement = driver.findElement(By.id("name"));
        Assert.assertTrue(nameElement.getText().contains("ThreadQA Test"), 
                "Имя должно содержать введенное значение");
    }

    @Test
    public void fillManyTextBoxesSeleniumTest() {
        driver.get("https://datatables.net/examples/api/form.html");
        
        // Выбор опции из выпадающего списка
        WebElement select = driver.findElement(By.className("dt-input"));
        select.sendKeys("50");
        
        // Получение всех текстовых полей
        List<WebElement> textFields = driver.findElements(
                By.xpath("//tbody//input[@type='text']"));
        
        // Заполнение всех полей
        for (WebElement field : textFields) {
            field.clear();
            field.sendKeys("threadqa selenium");
        }
        
        Assert.assertTrue(textFields.size() > 0, "Должны быть найдены текстовые поля");
    }
}
