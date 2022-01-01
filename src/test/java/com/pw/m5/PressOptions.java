package com.pw.m5;

import com.microsoft.playwright.Keyboard;
import com.pw.ScriptBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PressOptions extends ScriptBase {

    @Test
    public void pressOptions() {

        page.navigate(home);
        page.fill("#exampleFormControlInput1","myEmail@inbox.con");  // typo
        Keyboard kb = page.keyboard();

        kb.press("Backspace"); // delete the last character filled in
        kb.press("m"); // specify the right character to fix the typo

        // either you can press tab to move on to the drop-down or change focus
        page.focus("#contactReason");
        kb.press("ArrowDown");
        kb.press("ArrowDown"); //we use the press method again to mimic arrow down, twice. Unfortunately, the method doesn't have an option
                                    // that allows us to specify how many times we want to press something. Perhaps in a later version.
        Assertions.assertTrue(page.isVisible("text=OK, but please make it interesting"));

    }



}
