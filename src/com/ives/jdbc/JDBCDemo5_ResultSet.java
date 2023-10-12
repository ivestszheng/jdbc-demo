package com.ives.jdbc;


import com.ives.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC API 详解：Result
 */
public class JDBCDemo5_ResultSet {
    /**
     * 执行 DQL 语句
     * @throws Exception
     */
    @Test
     public void testResultSet() throws Exception{
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");

        // 2JDBCDemo. 获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select * from account";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // 光标向下移动一行，并且判断当前行是否有数据
//        while(rs.next()){
//            // 获取数据 getXXX()
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            double money = rs.getDouble(3);
//
//            System.out.println(id);
//            System.out.println(name);
//            System.out.println(money);
//            System.out.println("-----------------");
//        }
        while(rs.next()){
            // 获取数据 getXXX()
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("-----------------");
        }

        // 6. 关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }

    /**
     * 查询 account 账户表数据，封装为 Account 对象中，并且存储到 ArrayList 集合中
     * 1. 定义实体类 Account
     * 2. 查询数据，封装到 Account 对象中
     * 3. 将 Account 对象存入 ArrayList 集合中
     * @throws Exception
     */
    @Test
    public void testResultSet2() throws Exception{
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");

        // 2JDBCDemo. 获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select * from account";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // 创建集合
        List<Account> list = new ArrayList<>();

        while(rs.next()){
            Account account = new Account();
            // 获取数据 getXXX()
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            // 赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            list.add(account);
        }

        System.out.println(list);

        // 6. 关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }
}