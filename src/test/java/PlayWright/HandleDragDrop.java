package PlayWright;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandleDragDrop {
    Browser browser = null;
    Page page = null;


    @Test
    void dragDropTest() {
        try {
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
            page = browser.newPage();
            page.navigate("https://jqueryui.com/droppable/");
            FrameLocator frameLocator = page.frameLocator(".demo-frame");
           // frameLocator.locator("#draggable").dragTo(frameLocator.locator("#droppable"));
            //page.locator("").dragTo(page.locator(""));
            frameLocator.locator("#draggable").hover();
            page.mouse().down();
            frameLocator.locator("#droppable").hover();
            page.mouse().up();
            
        } finally {
            page.close();
            browser.close();
        }
    }
}
