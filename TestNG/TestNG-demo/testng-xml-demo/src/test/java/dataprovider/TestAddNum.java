package dataprovider;

import addNum.TwoIntAdd;
import mulNum.TowIntMul;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class TestAddNum {
    public int getRule(String str){
        if(str.equals("eq"))
            return 0;
        return str.equals("mt") ? 1 : 2;
    }
    @Test(dataProvider = "twoNum",dataProviderClass = GetDataFromDB.class)
    public void addTwoNum(int a, int b, int result, String rule){
        //0 表示等于， 1 表示大于， 2表示大于
        int r = getRule(rule);
        TwoIntAdd ti = new TwoIntAdd();
        switch (r){
            case 0:
                Assert.assertEquals(ti.addTwoInt(a,b), result);
                break;
            case 1:
                Assert.assertTrue(ti.addTwoInt(a,b) > result);
                break;
            case 2:
                Assert.assertTrue(ti.addTwoInt(a,b) < result);
                break;
            default:
                Assert.assertTrue(false);
        }
    }
    @Test(dataProvider = "dataFromExcel", dataProviderClass = GetDataFromFile.class)
    public void mulTwoNum(int a, int b, int result, String rule){
        //0 表示等于， 1 表示大于， 2表示大于
        int r = getRule(rule);
        TowIntMul tm = new TowIntMul();
        switch (r){
            case 0:
                Assert.assertEquals(tm.mulTowInt(a,b), result);
                break;
            case 1:
                Assert.assertTrue(tm.mulTowInt(a,b) > result);
                break;
            case 2:
                Assert.assertTrue(tm.mulTowInt(a,b) < result);
                break;
            default:
                Assert.assertTrue(false);
        }
    }
}
