package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepsLambdaTest {
    private static final String REPOSITORY = "selenide/selenide";
    private static final String ISSUE_TEXT = "Bad browser language in version 6+";

    @Test
    public void githubTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Переходим в Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем, что существует Issue с текстом" + ISSUE_TEXT, () -> {
            $(withText(ISSUE_TEXT)).shouldBe(Condition.visible);
        });
    }
}
