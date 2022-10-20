package PlayWrightSessionDemo;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorConcept {
    @Test
    void locators(){
        Playwright pw=Playwright.create();
        Browser browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
        //Single element
        Locator contactSales=page.locator("text=Why OrangeHRM").first();
        contactSales.hover();
        Locator oc=page.locator("(//div[@class='secondary-menu'])[2]//ul//li[contains(.,'Our Customers')]");
        oc.hover();
        page.locator("//h6[@class='list-sub-menu-title']//a[normalize-space()='Case Studies']").click();
        contactSales.click();
        page.title().contains("OrangeHRM");
        page.goBack();
        Locator countryOptions=page.locator("//select[@name='Country']//option");
        System.out.println(countryOptions.count());

//        for (int i=0;i<countryOptions.count();i++){
//            String text=countryOptions.nth(i).textContent();
//            System.out.println(text);
//        }
         List<String>options=countryOptions.allTextContents();
//        for (String ele:countryOptions.allTextContents()){
//        //System.out.println(i);
//            if(ele.equals("India")){
//                break;
//            }
//        }

        page.locator("#Form_getForm_Country").selectOption("India");
        options.forEach(e->System.out.println(e));


    }
}
