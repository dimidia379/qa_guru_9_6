package guru.qa;

import guru.qa.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class StepsAnnotatedTest {
    private static final String REPOSITORY = "selenide/selenide";
    private static final String ISSUE_TEXT = "Get web console logs from firefox";

    private WebSteps steps = new WebSteps();

    @Test
    public void githubTest() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.goToIssues();
        steps.shouldSeeIssueWithText(ISSUE_TEXT);
    }
}
