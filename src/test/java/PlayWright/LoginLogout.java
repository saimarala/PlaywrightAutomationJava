package PlayWright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginLogout {
    Browser browser = null;
    Page page = null;

    @Test
    void loginAndLogout() {
        try {
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
            page = browser.newPage();
            page.navigate("https://freelance-learn-automation.vercel.app/login");
            assertThat(page).hasTitle("Learn Automation Courses");
            page.locator("#email1").fill("admin@email.com");
            page.getByPlaceholder("Enter Password").fill("admin@123");
            page.getByText("Sign in").last().click();
            assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
            page.getByAltText("menu").click();
            page.getByText("Sign out").click();
            assertThat(page).hasURL(Pattern.compile("login"));
        } finally {
            page.close();
            browser.close();
        }


    }
}
