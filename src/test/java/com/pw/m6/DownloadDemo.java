package com.pw.m6;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Download;
import com.pw.ScriptBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DownloadDemo extends ScriptBase {

    @BeforeEach
    @Override
    protected void createContextAndPage() {

        context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));
//        context = browser.newContext(); // won't work without setAcceptDownloads()
        page = context.newPage();
        page.setViewportSize(1920, 1080);
    }

    @Test
    public void downloadTestWithHandler() {

        page.navigate(home);


        page.onDownload(download -> {
            System.out.println(download.path());
            download.saveAs(Paths.get(new File("C:\\Users\\Sadik Akkaya\\Desktop\\PlaywrightDownloads\\downloaded.zip").toURI()));
        });

        page.click("text=Download ZIP");

/*  C:\Users\SADIKA~1\AppData\Local\Temp\playwright-artifacts-5u5wZG\210c96ae-2d2a-4ccd-8ef0-1824f6a1adc2
And the standard output shows where Playwright stores the temporary artifacts. A folder with a random hash for a name.
However, this folder is already gone because Playwright cleaned it up the moment the test finished and the process stopped.
 However, if I go to this path, I will see the .ZIP file and I can preview the PDF just fine.
 */
    }

    @Test
    public void downloadTestWithWaitForEvent() {
        page.navigate(home);

        Download download = page.waitForDownload(() -> {
            page.click("text=Download ZIP");
        });


        Path path = download.path();
        System.out.println(path);

    }


}
