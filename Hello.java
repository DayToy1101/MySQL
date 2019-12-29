package com.jane.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Hello {
    public static void main(String[] args) {
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/",
                    "root","");
            Statement stmt=connection.createStatement();
            stmt.execute("create database xsb");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
