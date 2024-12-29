package PlayWright;

import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.List;

public class HandleWindowsWithTitles {

    @Test
    void handleWindowsWithTitlesValidate() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        Locator allLinks = page.locator("//form[@class='login-form']//following-sibling::div[@class='social']/child::div[@class='social-btns']//a");
        for (int i = 0; i < allLinks.count(); i++) {
            allLinks.nth(i).click();
        }
        List<Page> allPages = context.pages();
        for (Page p : allPages) {
            if (p.title().contains("Facebook")) {
                p.bringToFront();
                p.locator("nput[name='email']").last().fill(new Faker().name().firstName());
                break;
            }
        }
        page.bringToFront();
        page.getByPlaceholder("Enter Email").fill(new Faker().name().lastName());
        page.close();
        context.close();
        browser.close();
    }
}
