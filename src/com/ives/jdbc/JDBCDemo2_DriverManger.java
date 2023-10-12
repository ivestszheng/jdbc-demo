package com.ives.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC 快速入门
 */
public class JDBCDemo2_DriverManger {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");

        // 2JDBCDemo. 获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义 sql
        String sql = "update account set money = 2000 where id = 1";

        // 4. 获取执行 sql 的对象 Statement
        Statement stmt = conn.createStatement();

        // 5. 执行 sql
        int count = stmt.executeUpdate(sql);
        if (count > 0){
            System.out.println("修改成功~");
        }else{
            System.out.println("修改失败~");
        }

        // 6. 关闭资源
        stmt.close();
        conn.close();
    }
}
