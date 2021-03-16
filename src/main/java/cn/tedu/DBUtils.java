package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtils {
    private static DruidDataSource ds; //静态变量

    static {
        //读取配置文件
        //创建属性对象
        Properties p = new Properties();
        //获取文件的输入流(会自动去resources工程下找目录文件)
        InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //让文件和属性对象建立连接(并抛出异常)
        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取数据(不管存的什么类型,只能获取字符串)
        String driver = p.getProperty("db.driver");
        String uri = p.getProperty("db.url");
        String username = p.getProperty("db.username");
        String password = p.getProperty("db.password");

        //创建数据库连接池对象
        ds = new DruidDataSource();
        //设置数据库连接信息
        ds.setDriverClassName(driver);
        ds.setUrl(uri);
        ds.setUsername(username);
        ds.setPassword(password);
        //设置初始化连接数量
        ds.setInitialSize(3);
        //设置最大连接数量
        ds.setMaxActive(5);
    }
    public static Connection getConn() throws Exception {
        //获取连接对象(抛出异常)
        Connection conn = ds.getConnection();
        System.out.println(conn);
        return conn;
    }
}
