package PlayWrightSessionDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.util.List;

public class VisibleElements {

    @Test
    void visible(){
        Playwright pw=Playwright.create();
        Browser browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.amazon.in/");
        List<String>linksText=page.locator(("a:visible")).allInnerTexts();
       // linksText.forEach(e->System.out.println(e));
        //linksText.stream().filter(e->e.endsWith("amazon")).count();

        page.close();
        browser.close();
        pw.close();


    }
}
