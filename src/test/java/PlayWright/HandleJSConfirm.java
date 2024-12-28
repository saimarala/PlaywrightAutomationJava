package PlayWright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HandleJSConfirm {

    @Test
    void handleAlertValidate() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog -> {
            Reporter.log(dialog.message(),true);
            Assert.assertTrue(dialog.message().contains("I am a JS Confirm"));
           // dialog.accept();
            dialog.dismiss();
        });
        page.locator("//button[normalize-space()='Click for JS Confirm']").click();
        page.close();
        browser.close();
    }
}
