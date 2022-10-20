package PlayWrightSessionDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class FrameHandle {
    @Test
    void frame(){
        Playwright pw=Playwright.create();
        Browser browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.formsite.com/templates/registration-form-templates/application-form/");
        page.locator("//img[@alt='Application Form Templates']").click();
        page.frameLocator("//iframe[contains(@id,'frame')]").locator("#RESULT_TextField-1").first().fill("test");
        //page.pause();
        page.navigate("https://selectorshub.com/xpath-practice-page/");


    }
}
