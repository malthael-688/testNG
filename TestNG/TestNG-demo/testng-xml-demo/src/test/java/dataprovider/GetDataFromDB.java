package dataprovider;

import org.testng.annotations.DataProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetDataFromDB {
    @DataProvider(name = "twoNum")
    public static Object[][] getTwoNumFromDB(){
        Object[][] objects = null;
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = Connect.getInstance().getConnection();
            s = c.createStatement();
            String sql = "select * from addNum";
            rs = s.executeQuery(sql);
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            objects = new Object[rowcount][4];
            int i = 0;
            while(rs.next()){
                objects[i][0] = rs.getInt(1);

                objects[i][1] = rs.getInt(2);

                objects[i][2] = rs.getInt(3);

                objects[i][3] = rs.getString(4);

                i++;
            }
            Connect.closeConnection(c,s,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
