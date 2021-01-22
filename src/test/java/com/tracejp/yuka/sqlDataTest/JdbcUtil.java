package com.tracejp.yuka.sqlDataTest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*********************************
 * @author traceJP
 *********************************/
public class JdbcUtil {

    public static Connection getConnection() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            String url = "jdbc:mysql://localhost:3306/yuka_music?serverTimezone=GMT%2B8";
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "123456");
            Connection conn = driver.connect(url, info);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static void closeResource(Connection conn, Statement ps) {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
