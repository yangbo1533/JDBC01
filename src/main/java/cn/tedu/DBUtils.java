package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    public static Connection getConn() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root", "root");
        return conn;
    }
}
