package forShow;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class PrintShowOrder {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before Suit!");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class!");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method!");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test void test3(){
        System.out.println("Test 3");
    }
}
