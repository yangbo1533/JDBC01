package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        try (
                Connection conn = DBUtils.getConn();
                ){
//            Statement s = conn.createStatement();
//            ResultSet rs = s.executeQuery
//                    ("select id from user where username = '"+username+"' and password = '"+password+"'");

            //通过PreparedStatement解决注入问题
            String sql = "select id from user where username = ? and password = ?";
            //创建ps对象时,对SQL语句进行编译,此时锁死SQL语句的业务逻辑,不受用户输入内容影响
            PreparedStatement ps = conn.prepareStatement(sql);
            //替换掉SQL语句中的?  第一个参数代表?的位置
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            //如果查到了数据说明登录成功,反之失败
            if (rs.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
