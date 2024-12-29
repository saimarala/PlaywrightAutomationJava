package PlayWright;

import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Pattern;

public class HandleFrames {

    @Test
    void handleFramesValidate() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://www.redbus.in/");
        page.locator("//span[text()='Account']").click();
        page.locator("//span[text()='Login/ Sign Up']").click();
        List<Frame> allFrames = page.frames();
        Reporter.log("Total number of frames : " + allFrames.size(), true);
//        FrameLocator frame = page.frameLocator("//iframe[@class='modalIframe']").last();
//        frame.locator("#mobileNoInp").fill(String.valueOf(new Faker().number().randomNumber()));
        //first way
        //page.frameLocator("//iframe[@class='modalIframe']").last().locator("#mobileNoInp").fill(String.valueOf(new Faker().number().randomNumber()));
        //second way
//        Frame frame=page.frameByUrl(Pattern.compile(".*login.*"));
//        frame.locator("#mobileNoInp").fill(String.valueOf(new Faker().number().randomNumber()));
        page.frameByUrl(Pattern.compile(".*login.*")).locator("#mobileNoInp").fill(String.valueOf(new Faker().number().randomNumber()));
        
        page.close();
        context.close();
        browser.close();
    }
}
