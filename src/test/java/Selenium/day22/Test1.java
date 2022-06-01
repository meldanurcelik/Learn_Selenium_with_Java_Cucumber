package Selenium.day22;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    //@Parameters("a")
    @Parameters({"a", "b"})
    @Test
    public void m1(String s1, String s2) {
        System.out.println(s1 + s2);
    }

    @Test
    public void m2() {
        System.out.println("Hello");
    }

}