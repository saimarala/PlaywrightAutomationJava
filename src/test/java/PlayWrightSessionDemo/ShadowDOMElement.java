package PlayWrightSessionDemo;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class ShadowDOMElement {
    @Test
    void shadowElement(){
        Playwright pw=Playwright.create();
        Browser browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcx=browser.newContext();
        Page page=brcx.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        page.locator("//a[text()='Resources']").hover();
        page.locator("(//ul[@class='sub-menu']//following::a[.='Practice Page'])[2]").click();
        page.frameLocator("#pact").locator("#tea").fill("yes");
        page.locator("#userPass").click();
        page.keyboard().press("Tab");
        page.keyboard().insertText("Test");
       // page.locator("#userPass").press("Tab");

        page.close();
        brcx.close();
        browser.close();
        pw.close();
    }
}
