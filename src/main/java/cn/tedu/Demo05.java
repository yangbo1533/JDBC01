package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Demo05 {
    public static void main(String[] args) throws IOException {
        //创建属性对象
        Properties p = new Properties();
        //获取文件的输入流(会自动去resources工程下找目录文件)
        InputStream is = Demo02.class.getClassLoader().getResourceAsStream("my.properties");
        //让文件和属性对象建立连接(并抛出异常)
        p.load(is);
        //读取数据(不管存的什么类型,只能获取字符串)
        String name = p.getProperty("name");
        String age = p.getProperty("age");
        System.out.println(name+age);

    }
}
