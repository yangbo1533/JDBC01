package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        //获取链接
        try (
                Connection conn = DBUtils.getConn();
                ){
            //得到执行SQL语句的对象
            Statement s = conn.createStatement();
            //执行查询SQL语句
            ResultSet rs = s.executeQuery("select ename,sal from emp");
            while (rs.next()){
                //1,通过字段名获取数据
                String name = rs.getString("ename");
                //2,通过字段的位置获取数据
                double sal = rs.getDouble(2);
                System.out.println(name+":"+sal);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
