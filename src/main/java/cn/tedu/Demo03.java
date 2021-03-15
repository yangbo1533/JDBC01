package cn.tedu;

import org.junit.Test;

import java.sql.*;

public class Demo03 {
    @Test //多单元测试(可以代表一个类中存在多个main方法)
    public void test01() throws Exception { //增加操作
        System.out.println("test01");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root", "root");
        Statement s = conn.createStatement();
        //执行插入的sql语句
        String sql = "insert into emp(empno,ename) values (101,'灭霸')";
        s.execute(sql);
        conn.close();
        System.out.println("执行完毕");

    }
    @Test //多单元测试(可以代表一个类中存在多个main方法)
    public void test02() throws Exception { //修改操作
        System.out.println("test02");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root", "root");
        Statement s = conn.createStatement();
        String sql = "update emp set ename = '超人' where ename = '灭霸'";
        s.execute(sql);
        conn.close();
        System.out.println("执行完毕");

    }
    @Test //多单元测试(可以代表一个类中存在多个main方法)
    public void test03() throws Exception { //删除操作
        System.out.println("test03");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root", "root");
        Statement s = conn.createStatement();
        String sql = "delete from emp where ename = '超人'";
        s.execute(sql);
        conn.close();
        System.out.println("执行完毕");

    }
    @Test
    public void test04() throws Exception { //查询操作
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root", "root");
        Statement s = conn.createStatement();
        //执行查询的SQL语句
        String sql = "select * from emp";
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()){
            String name = rs.getString("ename");
            double sal = rs.getDouble("sal");
            String deptno = rs.getString("deptno");
            System.out.println(name+":"+sal+":"+deptno);
        }

    }
}
