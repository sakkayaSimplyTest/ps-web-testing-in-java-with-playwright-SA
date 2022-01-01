package com.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ScriptBase {

    private final String webDir = "file:///" + System.getProperty("user.dir") + "\\src\\web\\";
    protected String home = webDir + "home.html";
    protected String advantages = webDir + "advantages.html";


    protected static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }


    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920,1080);
    }

    @AfterEach
    void closeContext() {
        context.close();  // page i de kapatiyor
    }

    @AfterAll
    static void closeBrowser() {
//        browser.close();
        playwright.close();           // browser.close(); u da kapsiyor                       playwright > browser > context > page
    }


}
