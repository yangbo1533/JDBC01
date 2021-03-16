package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo06 {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象
        DruidDataSource ds = new DruidDataSource();
        //设置数据库连接信息
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        ds.setUsername("root");
        ds.setPassword("root");
        //设置初始化连接数量
        ds.setInitialSize(3);
        //设置最大连接数量
        ds.setMaxActive(5);
        //获取连接对象(抛出异常)
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
