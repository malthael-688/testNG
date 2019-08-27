package threads;

import org.testng.annotations.Test;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class demo {
    int j = 1;
    @Test(invocationCount = 10000)
    public void printCount(){
        j++;
        for(int k = 0; k < 1000000000; k++){

        }
        System.out.println("j=" + j);
    }
}
