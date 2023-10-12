package com.ives.jdbc;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 执行 DDL 语句
 */
public class JDBCDemo4_Statement {
    /**
     * 执行 DML 语句
     * @throws Exception
     */
    @Test
     public void testDML() throws Exception{
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");

        // 2JDBCDemo. 获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义 sql
        String sql = "drop database db2";

        // 4. 获取执行 sJDBCDemo4_Statementql 的对象 Statement
        Statement stmt = conn.createStatement();

        // 5. 执行 sql
        int count = stmt.executeUpdate(sql); // 执行完 DDL 语句，可能是 0
        System.out.println("count"+count);
//        if (count > 0){
//            System.out.println("修改成功~");
//        }else{
//            System.out.println("修改失败~");
//        }

        // 6. 关闭资源
        stmt.close();
        conn.close();
    }
}