package com.ives.jdbc;


import com.mysql.cj.xdevapi.PreparableStatement;
import org.junit.Test;

import java.sql.*;

/**
 * API 详解 PreparedStatement
 */
public class JDBCDemo7_PreparedStatement {
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

//        定义 sql
        String sql = "select * from tb_user where username = ? and password = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // pstmt 会进行转义，转成文本
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        // 执行 sql
        ResultSet rs = pstmt.executeQuery();

        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功~");
        }else{
            System.out.println("登录失败~");
        }

//         6. 关闭资源
        rs.close();
        pstmt.close();
        conn.close();
    }
}