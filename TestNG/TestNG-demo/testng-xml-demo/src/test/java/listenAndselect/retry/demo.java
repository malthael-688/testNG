package listenAndselect.retry;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class demo {
    @BeforeClass
    public void bfClass(){
        System.out.println("BeforeClass");
    }

    @Test(groups = "diao",retryAnalyzer = listenAndselect.retry.Retry.class)
    public void test1(){
        System.out.println("test1 begin...");
        int[] a = new int[1];
        System.out.println(a[1000]);
        System.out.println("test1 end!");
    }


    @AfterClass
    public void afClass(){
        System.out.println("AfterClass");
    }
}
