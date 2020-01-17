package com.jane.mysql;

import java.sql.*;
public class InsertCase {
    public static void createTable(){
        Connection connection = null;
        Statement stmt = null;

        try {
            //1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/xsb",
                    "root",
                    ""
            );
            //3. 创建语句对象
            stmt = connection.createStatement();
            //4. 执行
            String sql = "create table " +
                    "jdbctable(col1 int, col2 varchar(20))";
            stmt.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            /*必须要有资源释放*/
            try {
                if (stmt != null){
                    stmt.close();
                }

                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void insertIntoTable(){
        Connection connection = null;
        Statement stmt = null;

        try {
            //1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/xsb",
                    "root",
                    ""
            );
            //3. 创建语句对象
            stmt = connection.createStatement();
            //4. 执行
            String sql = "insert into jdbctable(col1, col2)" +
                    "value (1, 'hello')";
            stmt.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            try {
                if (stmt != null){
                    stmt.close();
                }

                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void selectTable(){
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/xsb",
                    "root",
                    ""
            );
            //3. 创建语句对象
            stmt = connection.createStatement();
            //4. 执行
            String sql = "select * from jdbctable";
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Integer col1 =
                        rs.getInt("col1");
                String col2 = rs.getString("col2");

                System.out.println("col1 = " + col1
                        + " col2" + col2);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            try {
                if (stmt != null){
                    stmt.close();
                }

                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        //createTable();
        insertIntoTable();
        selectTable();
    }
}
