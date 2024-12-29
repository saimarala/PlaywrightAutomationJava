package PlayWright;

import com.microsoft.playwright.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class ScreenshotInPlaywright {

    @Test
    void screenshotValidate() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
        Page page = browser.newPage();
        page.navigate("https://www.naukri.com/");
        //specific element
        page.locator("//a[@title='Jobseeker Login']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("ElementScreenshot.png")));
        //byte[] arr = page.screenshot();
        //visible portion of the page
        //page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots.png")));
        //full page
        // page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("screenshots.png")));
//        byte[] arr = page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("screenshots.png")));
//        Reporter.log(Base64.getEncoder().encodeToString(arr), true);
        Utility.captureScreenshot(page);
        page.close();
        browser.close();
    }
}
