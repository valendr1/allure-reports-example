package allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openPage(){
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository){
        $(".input-sm").click();
        $(".input-sm").sendKeys(repository);
        $(".input-sm").pressEnter();
    }

    @Step("Переходим по ссылке нужного репозитория {repository}")
    public void openRepository(String repository){

        $(By.linkText(repository)).click();
    }


    @Step("Смотрим наличие вкладки {search} на странице")
    public void searchTabIssue(String search){
        $$("#repository-container-header")
                .find(text(search))
                .shouldBe(visible);
    }
}
