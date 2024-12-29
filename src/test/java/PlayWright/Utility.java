package PlayWright;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class Utility {
    
    public static byte[] captureScreenshot(Page page){
        
        byte[] arr = page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("src/test/resources/Screenshots/screenshots.png")));
        
        return arr;
    }
}
