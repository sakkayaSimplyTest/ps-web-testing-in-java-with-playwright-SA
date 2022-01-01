package com.pw.m5;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import com.pw.ScriptBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NavigationOptions extends ScriptBase {

    @Test
    public void navigationOptions() {

//        page.navigate(home);
        page.navigate(home, new Page.NavigateOptions()
                .setTimeout(0)            // 0  ms
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)  //(WaitUntilState.LOAD) -> default options but WaitUntilState.DOMCONTENTLOADED is fastest Option
        );

        Assertions.assertEquals(page.title(), "Home Page");
    }

}
