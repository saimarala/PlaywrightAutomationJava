package PlayWright;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class FileUploaderWithoutInputTag {

    @Test
    void fileUploadValidate() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/upload");
        FileChooser fileChooser = page.waitForFileChooser(() -> page.locator("#drag-drop-upload").click());
        // fileChooser.setFiles(Paths.get("D:\\AutomationLabs\\PlaywrightAutomationJava\\src\\test\\resources\\Files\\file.PNG"));
        Path files[] = {Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\file.PNG")
                , Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\file.PNG"),
                Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\file.PNG")
        };
        //multiple files
        fileChooser.setFiles(files);
        page.close();
        browser.close();
    }
}
