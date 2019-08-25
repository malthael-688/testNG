package listenAndselect.report;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(demo.class)
public class test {
    @Test
    public void print(){
        System.out.println("123");
    }
}
