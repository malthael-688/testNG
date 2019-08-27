package listenAndselect.methodSelect;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class demo2 {
    @BeforeClass
    public void bfClass(){
        System.out.println("BeforeClass");
    }

    @Test(groups = "diao")
    public void test1(){
        System.out.println("test1");
    }

    @Test(groups = "others")
    public void test2(){
        System.out.println("test2");
    }

    @Test(groups = "others")
    public void test3(){
        System.out.println("test3");
    }

    @AfterClass
    public void afClass(){
        System.out.println("AfterClass");
    }
}
