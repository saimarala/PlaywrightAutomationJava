package PlayWright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.annotations.Test;

import java.io.IOException;

public class WaitsInPlaywright {
    Browser browser = null;
    Page page = null;

    @Test
    void waitsValidate() throws IOException {
        try {
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            page = browser.newPage();
            //default 30 secs
            page.navigate("https://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html", new Page.NavigateOptions().setTimeout(60000));
            //another way
            // page.setDefaultNavigationTimeout(60000);

            //elements wait
            page.setDefaultTimeout(5000);
            page.locator("//button[normalize-space()='Click me to start timer']").click();
            page.locator("//p[normalize-space()='WebDriver']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED).setTimeout(20000));
            page.waitForLoadState(LoadState.NETWORKIDLE);
        } finally {
            page.close();
            browser.close();
        }
    }
}
