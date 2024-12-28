package PlayWright;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterNewUser {
    Browser browser = null;
    Page page = null;

    @Test
    void registration() {
        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        assertThat(page).hasTitle("Learn Automation Courses");
        page.getByText("New user? Signup").click();
        // Locator locator= page.locator(".submit-btn");
        assertThat(page.locator(".submit-btn")).isDisabled();
        page.locator("#name").fill(new Faker().name().fullName());
        page.getByPlaceholder("Email").fill(new Faker().name().firstName()+"_"+new Faker().name().lastName()+"@gmail.com");
        page.getByPlaceholder("Password").fill("admin@123");
        page.click("//label[text()='Selenium']/preceding-sibling::div/input");
        assertThat(page.locator("//label[text()='Selenium']/preceding-sibling::div/input")).isChecked();
        //page.locator("//input[@value='Female']").click();
        page.locator("//input[@value='Female']").check();
        //page.pause();
        assertThat(page.locator("//input[@value='Female']")).isChecked();
        page.locator("#state").selectOption("Goa");
        String hobbies []={"Playing","Swimming"};
        page.locator("#hobbies").selectOption(hobbies);
        assertThat(page.locator(".submit-btn")).isEnabled();
        page.locator(".submit-btn").click();
        page.waitForTimeout(5000);
        page.close();
        browser.close();
    }
}
