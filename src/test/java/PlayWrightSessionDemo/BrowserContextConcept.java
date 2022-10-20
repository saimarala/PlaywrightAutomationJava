package PlayWrightSessionDemo;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class BrowserContextConcept {
  @Test
  void browserContext(){
    Playwright pw=Playwright.create();
    Browser browser= pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    BrowserContext brcx1=browser.newContext();
    Page p1=brcx1.newPage();
    p1.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    System.out.println(p1.title());
    BrowserContext brcx2=browser.newContext();
    Page p2=brcx2.newPage();
    p2.navigate("https://www.google.com/");
    System.out.println(p2.title());

    Locator l=p1.locator("//input[@placeholder='Username']");
    l.click();
    l.fill("Admin");

    p1.close();
    brcx1.close();

  }
}
