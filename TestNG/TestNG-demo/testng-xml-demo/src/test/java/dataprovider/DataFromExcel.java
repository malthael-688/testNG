package dataprovider;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataFromExcel {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    private static final String DataFileName = "C:\\Users\\10414\\Desktop\\新建 XLS 工作表.xls";
    /**
     * 判断文件是否是excel
     * @throws Exception
     */
    public static void checkExcelVaild(File file) throws Exception{

        if(!file.exists()){
            throw new Exception("文件不存在");
        }
        if(!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))){
            throw new Exception("文件不是Excel");
        }
    }
    /**
     * 判断Excel的版本,获取Workbook
     * @param in
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(InputStream in, File file) throws IOException {
        Workbook wb = null;
        if (file.getName().endsWith(EXCEL_XLS)) {  //Excel 2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }
    public Object[][] getData(String path) {
        if(path == null || path.equals("")){
            path = DataFileName;
        }
        Workbook workbook = null;
        Object[][] objects = null;
        try{
            File excelFile = new File(path); // 创建文件对象
            FileInputStream in = new FileInputStream(excelFile); // 文件流

            workbook = getWorkbok(in,excelFile);
            checkExcelVaild(excelFile);
            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
            Sheet sheet = workbook.getSheetAt(0);   // 遍历第1个Sheet
            objects = new Object[sheet.getLastRowNum() + 1][4];
            int i = 0;
            for (Row row : sheet){
                objects[i][0] = (int) row.getCell(0).getNumericCellValue();
                objects[i][1] = (int) row.getCell(1).getNumericCellValue();
                objects[i][2] = (int) row.getCell(2).getNumericCellValue();
                objects[i][3] = row.getCell(3).toString();
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return objects;
    }
}
