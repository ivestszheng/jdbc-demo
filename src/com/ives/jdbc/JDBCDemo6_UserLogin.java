package com.ives.jdbc;


import com.ives.pojo.Account;
import org.junit.Test;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户登录
 */
public class JDBCDemo6_UserLogin {
    /**
     * 演示 sql 注入
     * @throws Exception
     */
    @Test
     public void testLogin_Inject() throws Exception{
        // 2JDBCDemo. 获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户名和密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1'";

        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd+"'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功~");
        }else{
            System.out.println("登录失败~");
        }

        // 6. 关闭资源
//        rs.close();
//        stmt.close();
//        conn.close();
    }
}