package com.pw.m6;

import com.microsoft.playwright.Page;
import com.pw.ScriptBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScreenshotDemo extends ScriptBase {


    @Test
    public void screenshotTest() {


        page.navigate(home);
        page.selectOption("select#contactReason", "Bored");
        assertTrue(page.isVisible("#boredOption"));

        page.selectOption("select#contactReason", "Question");


        // this will fail - it's expected
        assertFalse(page.isVisible("#boredOption"),
                "The blue box should've disappeared after selecting another option");


    }

    @AfterEach
    public void cleanup(){

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("box.png")));

        // 1.Option DYNAMIC
        //        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(new File("C:\\Users\\Sadik Akkaya\\IdeaProjects\\ps-web-testing-in-java-with-playwright-SA\\src\\test\\java\\com\\pw\\screenshots\\box1.png").toURI())));

        // 2.Option DYNAMIC
//        String pathScreenshotFolder = "file://" + System.getProperty("user.dir") + "\\src\\test\\java\\com\\pw\\screenshots";
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(new File(pathScreenshotFolder + "\\box1.png").toURI())));

    }

}
