package cn.tedu;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        //创建表:use newdb3
        //create table user(id int primary key auto_increment,username varchar(20),password varchar(20)) charset = utf8;
        try (   //获取连接
                Connection conn = DBUtils.getConn();
                ){
            //创建执行SQL语句对象
            Statement s = conn.createStatement();
            //准备执行SQL语句
            String sql = "insert into user values(null,'"+username+"','"+password+"')";
            //执行SQL语句
            s.executeUpdate(sql);
            System.out.println("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
