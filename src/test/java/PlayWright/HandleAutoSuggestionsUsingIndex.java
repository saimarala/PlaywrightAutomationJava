package PlayWright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class HandleAutoSuggestionsUsingIndex {
    Browser browser = null;
    Page page = null;

    @Test
    void validateAutoSuggestions() {
        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
        page = browser.newPage();
        page.navigate("https://www.google.com/");
        page.locator("//textArea[@title='Search']").fill("Automation Testing");
        page.locator("//ul[@role='listbox']//li").nth(5).click();
        page.close();
        browser.close();
    }
}
