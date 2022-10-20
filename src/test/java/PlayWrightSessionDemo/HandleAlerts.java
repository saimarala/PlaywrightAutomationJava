package PlayWrightSessionDemo;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandleAlerts {
    @Test
    void alerts(){
        Playwright pw=Playwright.create();
        Browser browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcx=browser.newContext();
        Page page=brcx.newPage();

        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.locator("//button[text()='Click for JS Alert']").click();
      String in=  page.locator("//button[text()='Click for JS Alert']").innerText();
      System.out.println(in);

        page.onceDialog(d->d.dismiss());
        page.locator("//button[text()='Click for JS Confirm']").click();
        page.onceDialog(d->d.accept("PW"));
        page.locator("//button[text()='Click for JS Prompt']").click();

        page.close();
        brcx.close();
        browser.close();
        pw.close();
    }
}
