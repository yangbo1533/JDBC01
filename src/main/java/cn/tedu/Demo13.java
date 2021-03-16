package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入球队名");
        String teamName = sc.nextLine();
        System.out.println("请输入球员号");
        String playerName = sc.nextLine();
        /*
         * 1,查询球队表中是否有用户输入的球队,如果有查询出球队id
         *   如果没有则把球队添加到表中,同时还要获取出自增的id
         * 2,把球员名添加到球员表中,用到上面得到的id
         */

//        //获取连接
//        try (Connection conn = DBUtils.getConn();){
//            //1,把球队名添加到team表中
//            String sql = "insert into team values(null,?)";
//            //添加参数获取自增主键值
//            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            //获取SQL语句中的?的参数
//            ps.setString(1, teamName);
//            ps.executeUpdate();
//            //2,获取球队的自增的id值
//            ResultSet rs = ps.getGeneratedKeys();
//            rs.next(); //让游标下移
//            int teamId = rs.getInt(1);
//            //3,把球员名添加到player表中,用到上面得到的球队id
//            String sql1 = "insert into player values(null,?,?)";
//            PreparedStatement p = conn.prepareStatement(sql1);
//            p.setString(1, playerName);
//            p.setInt(2, teamId);
//            p.executeUpdate();
//            System.out.println("执行完毕");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
