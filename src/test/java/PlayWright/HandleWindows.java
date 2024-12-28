package PlayWright;

import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandleWindows {

    @Test
    void handleWindowsValidate() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        Page newPage=context.waitForPage(() -> {
            page.locator("//a[contains(@href,'facebook')]").first().click();
        });
        page.locator("input[name='email']").last().fill(new Faker().name().firstName());
        page.bringToFront();

        newPage.bringToFront();
        page.close();
        context.close();
        browser.close();
    }
}
