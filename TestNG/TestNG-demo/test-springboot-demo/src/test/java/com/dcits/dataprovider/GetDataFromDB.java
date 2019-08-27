package com.dcits.dataprovider;


import org.testng.annotations.DataProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class GetDataFromDB {
    @DataProvider(name = "getData")
    public static Object[][] getData(){
        Object[][] objects = null;
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = Connect.getInstance().getConnection();
            s = c.createStatement();
            String sql = "select * from login";
            rs = s.executeQuery(sql);
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            objects = new Object[rowcount][3];
            int i = 0;
            while(rs.next()){
                objects[i][0] = rs.getString(1);

                objects[i][1] = rs.getString(2);

                objects[i][2] = rs.getString(3);

                i++;
            }
            Connect.closeConnection(c,s,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
