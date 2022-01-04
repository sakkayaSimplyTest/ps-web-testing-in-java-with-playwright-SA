package com.pw.m7;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.sound.midi.ShortMessage;

import static com.pw.ScriptBase.home;

public class SetStrictSelectorsDemo {


    Playwright pw;

    @Test
    public void setStrictSelectorsDemo() throws InterruptedException {

        pw = Playwright.create();
        BrowserContext ctx = pw.chromium().launch()
//        BrowserContext ctx = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(4000))
                .newContext(new Browser.NewContextOptions()
                        .setStrictSelectors(true)
        );

        Page page = ctx.newPage();
        page.navigate(home);

//      page.isVisible("text=Submit");
        page.click("text=Submit");//  message='Error: strict mode violation: "text=Submit" resolved to 2 elements:

    }


    @AfterEach
    public void cleanup() {
        pw.close();
    }

}
