package forShow;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class PrintShowOrder2 {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println(this.getClass()+ "Before Suit!");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println(this.getClass()+ "Before Class!");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println(this.getClass()+ "Before Method!");
    }
    @Test
    public void test1(){
        System.out.println(this.getClass()+ "Test 1");
    }
    @Test
    public void test2(){
        System.out.println(this.getClass()+ "Test 2");
    }
    @Test void test3(){
        System.out.println(this.getClass()+ "Test 3");
    }
}
