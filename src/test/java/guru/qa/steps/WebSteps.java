package guru.qa.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository){
        $(linkText(repository)).click();
    }

    @Step("Переходим в Issues")
    public void goToIssues(){
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем, что существует issue c нужным текстом")
    public void shouldSeeIssueWithText(String issueText){
        $(Selectors.withText(issueText)).shouldBe(Condition.visible);
    }
}
