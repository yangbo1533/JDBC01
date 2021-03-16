package cn.tedu;

import java.sql.Connection;
import java.sql.Statement;

public class Demo09 {
    public static void main(String[] args) {
        try (
                Connection conn = DBUtils.getConn();
                ){
            String sql1 = "insert into user values(null,'张三','aaa')";
            String sql2 = "insert into user values(null,'李四','bbb')";
            String sql3 = "insert into user values(null,'王五','ccc')";
            Statement s = conn.createStatement();
            //添加到批量操作
            s.addBatch(sql1);
            s.addBatch(sql2);
            s.addBatch(sql3);
            //执行批量操作
            s.executeBatch();
            System.out.println("执行完毕");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
