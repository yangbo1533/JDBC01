package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true"
        ,"root", "root");
        System.out.println(conn);
        //创建SQL语句
        Statement s = conn.createStatement();
        //执行SQL语句
        String sql = "drop table jdbct1";
        s.execute(sql);
        //关闭资源
        conn.close();
        System.out.println("执行完毕");

    }
}
