package PlayWright;

import com.microsoft.playwright.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownload {
    Browser browser = null;
    Page page = null;

    @Test
    void fileDownloadValidate() throws IOException {
        try {
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            page = browser.newPage();
            page.navigate("https://the-internet.herokuapp.com/download");
            Download download = page.waitForDownload(() -> {
                page.locator("//a[text()='file.txt']").click();
            });
            String downloadPath = System.getProperty("user.dir") + "/src/test/resources/DownloadFiles/" + download.suggestedFilename();
            Reporter.log(downloadPath, true);
            //  Reporter.log(download.suggestedFilename(), true);
            Reporter.log(download.url(), true);
            download.saveAs(Paths.get(downloadPath));
            if (downloadPath.endsWith(".txt")) {
                Reporter.log("File Extension verified", true);
            } else {
                Reporter.log("File Extension verification failed", true);
                browser.close();
                return;
            }

            if (Files.size(Path.of(downloadPath)) > 0) {
                Reporter.log("File size verified", true);
            } else {
                Reporter.log("File size not verified", true);
                browser.close();
                return;
            }
            String dataFromFile=Files.readString(Path.of(downloadPath));

            if (dataFromFile.contains("Got it")) {
                Reporter.log("File content verified", true);
            } else {
                Reporter.log("File content not verified", true);
                browser.close();
                return;
            }

        } finally {
            page.close();
            browser.close();
        }
    }
}
