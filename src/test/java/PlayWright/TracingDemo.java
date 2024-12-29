package PlayWright;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TracingDemo {
    Browser browser = null;
    Page page = null;
    BrowserContext context =null;

    @Test
    void loginAndLogout() {
        try {
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
            context=browser.newContext();
            context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
            page = context.newPage();
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
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("src/test/resources/TraceViewer/Tracing.zip")));
            page.close();
            context.close();
            browser.close();
        }


    }
}
