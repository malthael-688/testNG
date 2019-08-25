package com.randomData.func;

import com.randomData.constant.CharConstant;
import com.randomData.rules.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Malthael
 * @date 2019/8/21
 * 随机生成测试
 * 假设我们输入的规则名字仅仅只有一个
 * 并且假设这东西全部都是你懂得
 * 全部都是是Y
 * 正确存储格式应该是用双层List来进行存储
 */
public class RandomFunc {
    static Random random = new Random();
    static String path = "C:\\Users\\lenovo\\Desktop\\GitHub\\testNG\\register.xls";
    static String ruleName = "";
    static ArrayList<Rule> rules = ReadFromExcel.getRulesFromExcel(path);
    //数据信息


    public static  ArrayList<ArrayList<String>> simpleGetRandomData() {
        ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
        //设置规则名字
        ruleName = rules.get(0).getRuleName();
        //约束变量法
        //动一其他不动
        int i = 0;


        for (Rule rule : rules) {
            //首先拿到正确的数据
            String[] data = getRightData();
            //开始循环开整
            if (rule.getTypeName().equals("account")) {
                //先来整个空的
                ArrayList<String> list1 = new ArrayList<String>();
                for (int j = 0; j < data.length; j++) {
                    if (j == 0) {
                        list1.add("");
                    } else
                        list1.add(data[j]);
                }
                datas.add(list1);
                //再来整个重复的
                ArrayList<String> list2 = new ArrayList<String>();
                ArrayList<String> list3 = new ArrayList<String>();
                for (int j = 0; j < data.length; j++) {
                    list2.add(data[j]);
                    list3.add(data[j]);
                }
                datas.add(list2);
                datas.add(list3);
                //再来个超过长度的
                String[] data1 = getLongData(i);
                ArrayList<String> list4 = new ArrayList<String>();
                for (int j = 0; j < data.length; j++) {
                    if (j==0)
                    {
                        list4.add(data1[0]);
                    }else
                        list4.add(data[j]);

                }
                datas.add(list4);
                //再来一个有特殊字符的
                ArrayList<String> list5 = new ArrayList<String>();
                for (int j = 0; j < data.length; j++) {
                    String str = new String(data[i]);
                    int length = str.length();
                    int min = random.nextInt(length - 1) + 1;
                    if (min<=0)
                    {
                        min=length/2;
                    }
                    for (int k = 0; k < min; k++) {
                        int index = random.nextInt(str.length());
                        char c = CharConstant.specialChar[random.nextInt(CharConstant.specialChar.length)];
                        char[] chars = str.toCharArray();
                        chars[index] = c;
                        str = new String(chars);
                    }
                    if (j==0)
                    {
                        list5.add(str);
                    }else
                        list5.add(data[j]);

                }
                datas.add(list5);
                //再来一个有字母的
                ArrayList<String> list6 = new ArrayList<String>();
                String str = new String(data[i]);
                for (int j = 0; j < data.length; j++) {
                    int length = str.length();
                    int min = random.nextInt(length - 1) + 1;
                    for (int k = 0; k < min; k++) {
                        int index = random.nextInt(str.length());
                        char c = CharConstant.chars[random.nextInt(CharConstant.chars.length)];
                        char[] chars = str.toCharArray();
                        chars[index] = c;
                        str = new String(chars);
                    }
                    if (j==0)
                    {
                        list6.add(str);
                    }else
                        list6.add(data[j]);

                }
                datas.add(list6);
            } else {
                //先是空的
                ArrayList<String> list7=new ArrayList<String>();
                for (int j = 0; j <data.length ; j++) {
                    if (j==i)
                    {
                        list7.add("");
                    }else
                        list7.add(data[j]);
                }
                datas.add(list7);
                //再来一个重复的
                ArrayList<String> list8 = new ArrayList<String>();
                ArrayList<String> list9 = new ArrayList<String>();
                for (int j = 0; j < data.length; j++) {
                    list8.add(data[j]);
                    list9.add(data[j]);
                }
                datas.add(list8);
                datas.add(list9);
                //再整一个超长度的
                int length=rule.getLength()+random.nextInt(10);
                ArrayList<String> list10=new ArrayList<String>();
                String string="";
                for (int j = 0; j <length ; j++) {
                    string+=CharConstant.chars[random.nextInt(CharConstant.chars.length)];
                }
                for (int j = 0; j <data.length ; j++) {
                    if (j==i)
                    {
                        list10.add(string);
                    }else
                        list10.add(data[i]);
                }
                datas.add(list10);
                //整一个有特殊字符的
                ArrayList<String> list11 = new ArrayList<String>();
                String s=new String(data[i]);
                for (int j = 0; j <data.length ; j++) {
                    int len = s.length();
                    int min = random.nextInt(len - 1) + 1;
                    System.out.println(len+"   "+min);
                    if (min<=0)
                    {
                        min=len/2;
                    }
                    for (int k = 0; k < min; k++) {
                        int index = random.nextInt(s.length());
                        char c = CharConstant.specialChar[random.nextInt(CharConstant.specialChar.length)];
                        char[] chars = s.toCharArray();
                        chars[index] = c;
                        s = new String(chars);
                    }
                    if (j==i)
                    {
                        list11.add(s);
                    }else
                        list11.add(data[j]);
                }
                datas.add(list11);
            }
            i++;
        }
        return datas;
    }

    public static String[] getRightData() {
        String[] data = new String[4];
        for (int j = 0; j < data.length; j++) {
            data[j] = "";
        }
        for (int j = 0; j < 4; j++) {
            Rule rule = rules.get(j);
            String typeName = rule.getTypeName();
            if (typeName.equals("account")) {
                int length = rule.getLength();
                int min = random.nextInt(8 - 1) + 1;
                int len = random.nextInt(length  - min) + min;
                for (int k = 0; k < len; k++) {
                    data[j] = data[j] + CharConstant.numbers[random.nextInt(10)];
                }
            } else {
                int length = rule.getLength();
                int min = random.nextInt(8 - 1) + 1;
                int len = random.nextInt(length + 1 - min) + min;
                for (int k = 0; k < len; k++) {
                    data[j] = data[j] + CharConstant.chars[random.nextInt(CharConstant.chars.length)];
                }
            }
        }
        return data;
    }

    public static String[] getLongData(int i) {
        String[] data = new String[4];
        for (int j = 0; j < data.length; j++) {
            data[j] = "";
        }
        for (int j = 0; j < 4; j++) {
            Rule rule = rules.get(j);
            String typeName = rule.getTypeName();
            if (typeName.equals("account")) {
                int length = rule.getLength();
                int len = random.nextInt(10) + length + 1;
                for (int k = 0; k < len; k++) {
                    data[j] = data[j] + CharConstant.numbers[random.nextInt(10)];
                }
            } else {
                int length = rule.getLength();
                int len = random.nextInt(10) + length + 1;
                for (int k = 0; k < len; k++) {
                    data[j] = data[j] + CharConstant.chars[random.nextInt(CharConstant.chars.length)];
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        RandomFunc randomFunc = new RandomFunc();

        ArrayList<ArrayList<String>> datas=simpleGetRandomData();
        for (ArrayList<String> arraylist : datas) {
            for (String string : arraylist) {
                System.out.print(string + "   ");
            }
            System.out.println();
        }
        System.out.println(ruleName);
    }
}
