package com.jane.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Hello1 {
    private static String HELLO = "nihao";
    private static long length = 1024;
    static
    {
        length = 33;
        int i = 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Connection connection = null;
        Statement stmt = null;
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");//通过反射机制加载
            //获取连接
            connection=DriverManager.getConnection("jdbc:mysql://localhost/",
                    "root","");
            //localhost表示本地主机，host表示主机jdbc：mysql：//表示一种协议
            stmt=connection.createStatement();
            stmt.execute("create database xsb");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
