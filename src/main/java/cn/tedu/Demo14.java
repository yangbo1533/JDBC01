package cn.tedu;

import java.sql.*;

public class Demo14 {
    public static void main(String[] args) {
        //获取连接
        try (Connection conn = DBUtils.getConn();){
            //获取数据库元数据对象
            DatabaseMetaData dmd = conn.getMetaData();
            System.out.println("数据库驱动名"+dmd.getDriverName());
            System.out.println("数据库名"+dmd.getDatabaseProductName());
            System.out.println("数据库连接地址名"+dmd.getURL());
            System.out.println("数据库驱动版本"+dmd.getDriverVersion());

            String sql = "select * from emp";
            //由于上述查询的表没有字段名,所以不使用解决注入问题的方法
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            //获取表元数据对象
            ResultSetMetaData rsm = rs.getMetaData();
            //获取表字段数量
            int count = rsm.getColumnCount();
            //遍历每个字段信息
            for (int i = 1; i < count; i++) {
                String name = rsm.getColumnName(i); //获取字段名
                String type = rsm.getColumnTypeName(i); //获取字段类型
                System.out.println(name+":"+type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
