package com.randomData;

import com.randomData.func.RandomFunc;
import com.randomData.func.WriteToExcel;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Malthael
 * @date 2019/8/27
 */
public class TestRandom {
    @Test(invocationCount = 100)
    public void test1() throws IOException, WriteException {
        RandomFunc randomFunc=new RandomFunc();
        ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
        for (int i = 0; i <20; i++) {
            ArrayList<ArrayList<String>> datas=RandomFunc.simpleGetRandomData();
            list.addAll(datas);
        }

        WriteToExcel.writeToExcel(list);
    }
}
