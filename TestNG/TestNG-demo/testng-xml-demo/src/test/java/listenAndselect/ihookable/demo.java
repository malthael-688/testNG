package listenAndselect.ihookable;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ihook.class)
public class demo {
    @Test(invocationCount = 10)
    public void test1(){
        System.out.println("Test1!");
    }

    @Test(invocationCount = 10)
    public void test2()
    {
        System.out.println("Test2!");
    }
}
