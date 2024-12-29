package PlayWright;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HandleSlider {
    Browser browser = null;
    Page page = null;


    @Test
    void sliderTest() {
        try {
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
            page = browser.newPage();
            page.navigate("https://jqueryui.com/slider/");
            
            Locator slideLocator=page.frameLocator(".demo-frame").locator("//span[contains(@class,'ui-slider-handle')]");
            slideLocator.focus();
            for (int i=0;i<10;i++){
                page.keyboard().press("ArrowRight");
            }
        } finally {
            page.close();
            browser.close();
        }


    }
}
