package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;



public class LambdaStepWithAllure {

    private static final String REPOSITORY = "eroshenkoam/allure-pdf";
    private static final String SEARCH = "Issue";


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка наличия вкладки Issue в репозитории")
    @Link(value = "Тестирование", url = "https://github.com")
    @Feature("Issue в репозитории")
    @DisplayName("Тест при помощи лямбда-выражений")
    void lambdaStepTest() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        //        Предусловия:
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        //        Шаги:
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".input-sm").click();
            $(".input-sm").sendKeys(REPOSITORY);
            $(".input-sm").pressEnter();
        });

        step("Переходим по ссылке нужного репозитория " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        // Ожидаемый результат:
        step("Смотрим наличие вкладки Issue на странице", () -> {
            $$("#repository-container-header")
                    .find(text(SEARCH))
                    .shouldBe(visible);
        });


    }


}
