package com.randomData;

import com.randomData.func.RandomFunc;
import com.randomData.func.WriteToExcel;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Malthael
 * @date 2019/8/21
 */
public class test {
    public static void main(String[] args) throws IOException, WriteException {
        RandomFunc randomFunc=new RandomFunc();
        ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
        for (int i = 0; i <20; i++) {
            ArrayList<ArrayList<String>> datas=RandomFunc.simpleGetRandomData();
            list.addAll(datas);
        }

        WriteToExcel.writeToExcel(list);

    }
}
