package PlayWrightSessionDemo;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

public class Inspector {
        public static void main(String[] args) {
            try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));
                BrowserContext context = browser.newContext();

                context.tracing().start(new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true));
                // Open new page
                Page page = context.newPage();
                // Go to https://selectorshub.com/
                page.navigate("https://selectorshub.com/xpath-practice-page/");
                // Click #menu-item-1437 >> text=Practice Page
               // page.locator("#menu-item-1437 >> text=Practice Page").click();
               // assertThat(page).hasURL("https://selectorshub.com/xpath-practice-page/");
                // Click [placeholder="Enter email"]
                page.locator("[placeholder=\"Enter email\"]").click();
                // 0× click
                page.locator("[placeholder=\"Enter email\"]").click();
                // Fill [placeholder="Enter email"]
                page.locator("[placeholder=\"Enter email\"]").fill("test123");

                context.tracing().stop(new Tracing.StopOptions()
                        .setPath(Paths.get("trace.zip")));
            }
        }
    }

