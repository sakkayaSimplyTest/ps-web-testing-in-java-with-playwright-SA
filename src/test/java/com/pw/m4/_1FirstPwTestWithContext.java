package com.pw.m4;

import com.microsoft.playwright.*;
import com.pw.ScriptBase;
import org.junit.jupiter.api.*;

public class _1FirstPwTestWithContext extends ScriptBase {


    @Test
    public void firstPlayWrightTestWithContext() {
        page.navigate(home);
        Assertions.assertEquals(page.title(), "Home Page");
    }

    @Test
    public void secondPlayWrightTestWithContext() {
        page.navigate(home);
        String content = page.content();      // gets the full HTML content of the page as a string
        Assertions.assertTrue(content.contains("Cat In The Bag"));
    }


}








