package PlayWright;

import com.microsoft.playwright.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HandleAutoSuggestions {
    Browser browser = null;
    Page page = null;

    @Test
    void validateAutoSuggestions() {
        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
        page = browser.newPage();
        page.navigate("https://www.google.com/");
        page.locator("//textArea[@title='Search']").fill("Automation Testing");
        Locator locator = page.locator("//ul[@role='listbox']//li");
        Reporter.log(String.valueOf(locator.count()), true);
        for (int i = 0; i < locator.count(); i++) {
            String text = locator.nth(i).innerText();
            Reporter.log(text, true);
            if (text.contains("automation testing jobs")) {
                locator.nth(i).click();
                break;
            }
        }
        page.close();
        browser.close();
    }
}
