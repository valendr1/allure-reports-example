package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Severity(SeverityLevel.CRITICAL)
@Feature("Issue в репозитории")
@Story("Проверка наличия вкладки Issue в репозитории")
public class SelenideTestWithAllure {


    @DisplayName("Тест на чистом Selenide")
    @Test
    void SelenideTest() {
        SelenideLogger.addListener("Allure", new AllureSelenide());

        //        Предусловия:
        open("https://github.com");
        //        Шаги:
        $(".input-sm").click();
        $(".input-sm").sendKeys("eroshenkoam/allure-pdf");
        $(".input-sm").pressEnter();
        $(By.linkText("eroshenkoam/allure-pdf")).click();

        // Ожидаемый результат:
        $$("#repository-container-header")
                .find(text("Issue"))
                .shouldBe(visible);
    }

}
