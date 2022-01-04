package com.pw.m6;

import com.pw.ScriptBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomJsExpressions extends ScriptBase {

    @Test
    public void localStorage() {

        page.navigate(home);
        Object obj = page.evaluate("()=> window.localStorage.getItem('clapped')");
        Assertions.assertNull(obj);

        page.click("#clap-image");

        String obj2 = (String) page.evaluate("()=> window.localStorage.getItem('clapped')");
         assertTrue(Boolean.parseBoolean(obj2));

        //OR
//        Object obj3 = page.evaluate("() => window.localStorage.getItem('clapped')");
//        assertTrue(Boolean.parseBoolean((String) obj3));

    }


    @Test
    public void evalOnSelector() {
        page.navigate(home);
        page.evalOnSelector("#hero-banner", "e => e.remove()");

        //document.getElementById("hero-banner").remove()      // DOM CONSOLE DAN REMOVE ETMEK ICIN JAVASCRIPT
        assertFalse(page.isVisible("#hero-banner"));
    }

    @Test
    public void evalOnSelectorAll() {
        page.navigate(advantages);
        Object obj = page.evalOnSelectorAll(".feature.col", "f => f.length");

        // OR
//        Object obj = page.evalOnSelectorAll(".feature.col", "f => f.length");

        assertEquals(3, obj);
    }


}
