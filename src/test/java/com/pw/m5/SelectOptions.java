package com.pw.m5;

import com.pw.ScriptBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectOptions extends ScriptBase {

    @Test
    public void selectScenario() {


        page.navigate(home);
        page.selectOption("#contactReason","Bored");  //<option value="Bored">I'm just bored</option>       ==>  selectOption  value of Attribute 'e gore bulur text e gore degil

        Assertions.assertTrue(page.isVisible("text=OK, but please make it interesting"));



    }


}
