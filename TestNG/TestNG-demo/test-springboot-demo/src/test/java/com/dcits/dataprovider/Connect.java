package com.dcits.dataprovider;

import java.sql.*;

/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class Connect {

    public String url = "jdbc:mysql://193.112.17.184:3306/springboottest?serverTimezone=GMT%2B8";
    public String username = "root";
    public String password = "nwpu.123.com";
    public static Connect instance = null;

    // 通过静态代码块注册数据库驱动，保证注册只执行一次
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connect() {
    }

    /**
     * 获得类实例
     *
     * @return
     */
    public static Connect getInstance() {
        // 给类加锁,防止线程并发
        synchronized (Connect.class) {
            if (instance == null) {
                instance = new Connect();
            }
        }
        return instance;
    }

    /**
     * 获得连接
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 关闭连接
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void closeConnection(Connection conn, Statement st,
                                       ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
