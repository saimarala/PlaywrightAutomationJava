package PlayWright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class HandleShadowDOM {

    @Test
    void shadowDOMValidate() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
        Page page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        // page.locator("#kils").fill("playwright");
        //make sure root is open - close not allowed
//        Locator shadowRoot= page.locator("div[id='userName']");
//        Locator element = shadowRoot.locator("#kils");
//        element.fill("playwright");
        //another way
        page.locator("#userName #kils").fill("test");
        page.close();
        browser.close();
    }
}
