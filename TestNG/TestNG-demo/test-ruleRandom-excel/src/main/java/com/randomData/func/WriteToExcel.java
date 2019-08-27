package com.randomData.func;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;

/**
 * @author Malthael
 * @date 2019/8/21
 */
public class WriteToExcel {
    static String path = "C:\\Users\\lenovo\\Desktop\\GitHub\\testNG\\data\\register_data.xls";

    public static void writeToExcel(ArrayList<ArrayList<String>> datas) throws IOException, WriteException {
        OutputStream os = new FileOutputStream(path,true);
        WritableWorkbook wb = Workbook.createWorkbook(os);
        CellView cv = new CellView();
        cv.setAutosize(true);
        WritableFont wfont = new WritableFont(WritableFont.createFont("宋体"), 22,
                WritableFont.BOLD, false,
                jxl.format.UnderlineStyle.NO_UNDERLINE,
                jxl.format.Colour.BLACK);                                   //设置单元格字体样式
        WritableCellFormat titleFormat = new WritableCellFormat(wfont);     //添加单元格字体
        titleFormat.setAlignment(Alignment.CENTRE);                         //设置文字居中对齐方式;
        WritableSheet sheet=wb.createSheet(RandomFunc.ruleName,0);
        int cols=0;
        int rows=0;
        for (ArrayList<String> list: datas) {
            cols=0;
            for (String s:list) {
                Label label=new Label(cols,rows,s);
                cols++;
                sheet.addCell(label);
            }
            rows++;
        }
        wb.write();
        wb.close();
        os.flush();
        os.close();
    }

}
