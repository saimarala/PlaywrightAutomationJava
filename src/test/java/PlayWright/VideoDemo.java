package PlayWright;

import com.microsoft.playwright.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class VideoDemo {
    @Test
    void videoDemoTest() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoSize(500, 500).setRecordVideoDir(Paths.get("src/test/resources/Videos/")));
        Page page = context.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        page.waitForTimeout(5000);
        page.locator("#email1").fill("test video");
        Reporter.log("Video recording can be checked at this location : " + page.video().path(), true);
        page.close();
        //make sure to close BrowserContext
        context.close();
        browser.close();

    }
}
