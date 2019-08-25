package threads;

import org.testng.annotations.Test;

public class demo2 {
    int i = 1;
    @Test(invocationCount = 10000)
    public void printCount(){
        i++;
        for(int k = 0; k < 1000000000; k++){

        }
        System.out.println("i=" + i);
    }
}
