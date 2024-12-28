package PlayWright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerifyTextMessages {
    Browser browser = null;
    Page page = null;

    @Test
    void validateTextMessages() {
        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        assertThat(page).hasTitle("Learn Automation Courses");
        page.getByText("Sign in").last().click();
        String expected = "Email and Password is required";
        Reporter.log("Error message via textContent is " + page.locator(".errorMessage").textContent(), true);
        Reporter.log("Error message via textContent is " + page.locator(".errorMessage").innerText(), true);
        Reporter.log("Error message via JS is " + page.evaluate("document.getElementsByClassName('errorMessage')[0]"), true);
        assertThat(page.locator(".errorMessage")).containsText(expected);
        assertThat(page.locator(".errorMessage")).containsText(Pattern.compile("is required"));
         page.close();
        browser.close();
    }
}
