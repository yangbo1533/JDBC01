package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询的页数");
        int page = sc.nextInt();
        System.out.println("请输入查询条数");
        int count = sc.nextInt();
        try (Connection conn = DBUtils.getConn();){
            String sql = "select id,username,password from user limit ?,?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //替换第一个? 代表跳过的条数
            ps.setInt(1, (page-1)*count);
            //替换第二个? 代表跳过的页数
            ps.setInt(2, count);
            //执行SQL语句
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String u = rs.getString(2);
                String p = rs.getString(3);
                System.out.println(id+u+p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
