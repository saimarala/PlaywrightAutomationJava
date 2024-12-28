package PlayWright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class FileUploader {

    @Test
    void fileUploadValidate() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/upload");
        //single
        page.locator("#file-upload").setInputFiles(Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\file.PNG"));
        //multiple
        Path files[] = {Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\file.PNG")
//                ,Path.of(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\file.PNG"),
//                Path.of(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\file.PNG")
        };
        page.locator("#file-upload").setInputFiles(files);
        //another way
        page.locator("#file-upload").setInputFiles(new Path[]{
                Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\file.PNG")
//                ,Path.of(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\file.PNG"),
//                Path.of(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\file.PNG")

        });


        // remove the files
        page.locator("#file-upload").setInputFiles(new Path[0]);
        page.close();
        browser.close();
    }
}
