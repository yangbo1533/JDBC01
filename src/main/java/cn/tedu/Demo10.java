package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo10 {
    public static void main(String[] args) {
        //通过批量操作往user表内插入100条数据
        try (Connection conn = DBUtils.getConn();){
            String sql = "insert into user values (null,?,?)";
            //解决注入问题
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i=1; i<=100; i++){
                //替换?部分
                ps.setString(1, "名字"+i);
                ps.setString(2, "密码"+i);
                //添加到批量操作里
                ps.addBatch();
                //避免内存溢出,每隔20次执行一次
                if (i%20==0){
                    ps.executeBatch();
                }
            }
            //执行批量操作
            ps.executeBatch();
            System.out.println("执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
