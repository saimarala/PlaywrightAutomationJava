package PlayWright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class JSExecutor {
    Browser browser = null;
    Page page = null;

    @Test
    void jsValidate() throws IOException {
        try {
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            page = browser.newPage();
            //default 30 secs
            page.navigate("https://login.yahoo.com/");
            Reporter.log(String.valueOf(page.locator("#persistent").boundingBox().height), true);
            Reporter.log(String.valueOf(page.locator("#persistent").boundingBox().width), true);
            //  page.locator("#persistent").click();
            //  page.evaluate("document.getElementById('persistent').click()");
            Locator checkbox = page.locator("#persistent");
            checkbox.evaluate("checkbox=>checkbox.click()");

        } finally {
            page.close();
            browser.close();
        }
    }
}
