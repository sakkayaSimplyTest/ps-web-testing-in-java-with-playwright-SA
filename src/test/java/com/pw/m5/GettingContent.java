package com.pw.m5;
import com.pw.ScriptBase;
import org.junit.jupiter.api.Test;


public class GettingContent extends ScriptBase {


    @Test
    public void gettingElements() {

        page.navigate(home);
        System.out.println("======= Text content =======");
        System.out.println(page.textContent("#hero-banner"));

        System.out.println("======= Inner Text =======");
        System.out.println(page.innerText("#hero-banner"));

        System.out.println("======= Inner HTML =======");
        System.out.println(page.innerHTML("#hero-banner"));

        System.out.println("======= Get Attribute =======");
        // <img src="images/bag.png" class="d-block mx-lg-auto img-fluid" alt="Bag" width="140" height="100" loading="lazy">
        System.out.println(page.getAttribute("img", "alt")); // bag
        System.out.println(page.getAttribute("img", "src")); // "img.jpb




    }



}
