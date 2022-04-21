package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTestWithAllure {

    private static final String REPOSITORY = "eroshenkoam/allure-pdf";
    private static final String SEARCH = "Issue";

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка наличия вкладки Issue в репозитории")
    @Link(value = "Тестирование", url = "https://github.com")
    @Feature("Issue в репозитории")
    @DisplayName("Тест с использованием аннотации @Step")
    public void annotatedStepTest() {

        SelenideLogger.addListener("Allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();

        //        Предусловия:
        webSteps.openPage();
        //        Шаги:
        webSteps.searchRepository(REPOSITORY);
        webSteps.openRepository(REPOSITORY);
        // Ожидаемый результат:
        webSteps.searchTabIssue(SEARCH);
    }
}
