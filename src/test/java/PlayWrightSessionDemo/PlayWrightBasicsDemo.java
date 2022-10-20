package PlayWrightSessionDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightBasicsDemo {

        void test(){
                Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch();
                Page page=browser.newPage();
                page.navigate("https://opensource-demo.orangehrmlive.com/");
                String title=page.title();
                System.out.println("page title : "+title);
                String url=page.url();
                System.out.println("url is : "+url);
                browser.close();
                playwright.close();
        }

}
