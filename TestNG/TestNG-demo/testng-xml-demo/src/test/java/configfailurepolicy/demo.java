package configfailurepolicy;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class demo {
    @BeforeMethod
    private void before(){
        int i = 1;
        i = i / 0;
        System.out.println("DoneBefore");
    }
    @Test
    private void testSuccess(){
        System.out.println("done testSuccess()");
    }
    @AfterMethod
    private void after(){
        System.out.println("DoneAfter");
    }
}
