package dataprovider;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class GetDataFromFile {
    @DataProvider(name = "dataFromExcel")
    public static Object[][] getExcelData(){
        DataFromExcel dataFromExcel = new DataFromExcel();
        return dataFromExcel.getData(null);
    }
}
