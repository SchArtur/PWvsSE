package core;

import com.microsoft.playwright.ElementHandle;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Класс для параллельного запуска теста fillManyTextBoxes 100 раз
 */
public class PlayWrightTestsParallel extends BaseTest {

    @Test(invocationCount = 100, threadPoolSize = 5, description = "Запуск fillManyTextBoxes 100 раз в 5 потоков")
    public void fillManyTextBoxes() {
        page.navigate("https://datatables.net/examples/api/form.html");
        //Выбираем из выпадающего списка значение
        page.selectOption("[class=dt-input]", "50");
        //Получаем нужные элементы на странице
        List<ElementHandle> fields = page.querySelectorAll("//tbody//input[@type='text']");
        //Заполняем все элементы текстом
        fields.forEach(x -> x.fill("threadqa playwright"));
    }
}
