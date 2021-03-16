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
        //获取连接
        try (Connection conn = DBUtils.getConn();){
            String sql = "select id from team where name=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,teamName);
            ResultSet rs = ps.executeQuery();
            int teamId = 0;
            //判断是否查询到
            if (rs.next()){//查询到了球队
                teamId = rs.getInt(1);
            }else{//没有该球队
                //添加球队到team表
                String tsql = "insert into team values(null,?)";
                PreparedStatement tps = conn.prepareStatement(tsql,
                        Statement.RETURN_GENERATED_KEYS);
                tps.setString(1,teamName);
                tps.executeUpdate();
                System.out.println("球队添加完成!");
                ResultSet trs = tps.getGeneratedKeys();
                trs.next();//游标下移
                teamId = trs.getInt(1);
            }
            //添加球员到球员表
            String psql = "insert into player values(null,?,?)";
            PreparedStatement pps = conn.prepareStatement(psql);
            pps.setString(1,playerName);
            pps.setInt(2,teamId);
            pps.executeUpdate();
            System.out.println("球员添加完成");
        } catch (Exception e) {
            e.printStackTrace();
        }

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
