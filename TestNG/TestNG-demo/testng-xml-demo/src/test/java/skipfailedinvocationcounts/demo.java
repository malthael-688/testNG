package skipfailedinvocationcounts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class demo {
    @Test(invocationCount = 3)
    public void test1(){
        int i = 0;
        Assert.assertEquals(i,1);
        System.out.println(i + " == 1");
    }
    @Test(invocationCount = 3)
    public void test2(){
        int i = 1;
        Assert.assertEquals(i,1);
        System.out.println(i + " == 1");
    }
    @AfterMethod
    public void after(){
        System.out.println("After");
    }
}
