package PlayWright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class KeyboardDemo {
    Browser browser = null;
    Page page = null;


    @Test
    void keyboardTest() {
        try {
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
            page = browser.newPage();
            page.navigate("https://freelance-learn-automation.vercel.app/login");
            assertThat(page).hasTitle("Learn Automation Courses");
            page.locator("#email1").fill("testkybiard@gmail.com");
            // page.keyboard().press("Enter");
            
//            page.keyboard().down("Control");
//            page.keyboard().press("a");
//            page.keyboard().up("Control");
//
//            page.keyboard().down("Control");
//            page.keyboard().press("c");
//            page.keyboard().up("Control");
//
//            //  page.keyboard().press("Enter");
//            page.keyboard().press("Tab");
//
//            page.keyboard().down("Control");
//            page.keyboard().press("v");
//            page.keyboard().up("Control");
            //another way
            page.keyboard().press("Control+A");
            page.keyboard().press("Control+C");
            page.keyboard().press("Tab");
            page.keyboard().press("Control+V");

        } finally {
            page.close();
            browser.close();
        }


    }
}
