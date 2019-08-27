package testaddNum;

import org.testng.annotations.Test;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class getParamFromXml {
    @Test(priority = 2)
    public void printDone(){
        System.out.println("DONE!!!!");
    }
    @Test(priority = 10)
    public String getReturnString(){
        System.out.println("Return test2!");
        return "test2";
    }
}
