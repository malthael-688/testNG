package com.randomData.func;

import com.randomData.rules.Rule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author Malthael
 * @date 2019/8/21
 * 从excel中读取规则
 */
public class ReadFromExcel {

    public static ArrayList<Rule> getRulesFromExcel(String filepath) {
        ArrayList<Rule> rules = new ArrayList<Rule>();
        Workbook wb = null;
        try {
            wb = Workbook.getWorkbook(new File(filepath));
            Sheet sheet = wb.getSheet(0);
            int clos = sheet.getColumns();    //获得列有多少个
            int rows = sheet.getRows();       //获得行有多少个
            for (int i = 1; i < rows; i++) {
                int j = 0;
                String ruleName = sheet.getCell(j++, i).getContents();
                String typeName = sheet.getCell(j++, i).getContents();
                String type = sheet.getCell(j++, i).getContents();
                int length = Integer.valueOf(sheet.getCell(j++, i).getContents());
                boolean hasSpecial = sheet.getCell(j++, i).getContents().equals("Y") ? true : false;
                boolean hasCross = sheet.getCell(j++, i).getContents().equals("Y") ? true : false;
                boolean hasNumber = sheet.getCell(j++, i).getContents().equals("Y") ? true : false;
                boolean hasChar = sheet.getCell(j++, i).getContents().equals("Y") ? true : false;
                boolean hasSame = sheet.getCell(j++, i).getContents().equals("Y") ? true : false;
                boolean hasEmpty = sheet.getCell(j++, i).getContents().equals("Y") ? true : false;
                Rule rule = new Rule(ruleName, typeName, type, length, hasSpecial, hasCross, hasNumber, hasChar, hasSame, hasEmpty);
                rules.add(rule);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        for (Rule rule:rules
             ) {
            System.out.println(rule.toString());
        }
        return rules;
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\lenovo\\Desktop\\GitHub\\testNG\\register.xls";
        getRulesFromExcel(path);
    }
}
