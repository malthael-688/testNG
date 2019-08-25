package groups;

import org.testng.annotations.Test;

public class demo{
    @Test(groups = "test1")
    public void test1(){
        System.out.println("groups1-test1");
    }
    @Test(groups = "test2")
    public void test2(){
        System.out.println("groups2-test2");
    }
    @Test(groups = "test3")
    public void test3(){
        System.out.println("groups3-test3");
    }
    @Test(groups = "test4")
    public void test4(){
        System.out.println("groups4-test4");
    }
}
