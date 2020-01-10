package com.bit.db;

import com.bit.data.Student;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOperator {
    private static String URL="jdbc:mysql://localhost/dt";
    private static String User="root";
    private static String password="";
    public static DataSource getDataSource()
    {
        MysqlDataSource datasource=new MysqlDataSource();
        datasource.setURL(URL);
        datasource.setUser(User);
        datasource.setPassword(password);
        return datasource;
    }
    //插入学生表
    public static void insertStu(Student stu)
    {
        //获取数据源
        java.sql.Connection connection=null;
        PreparedStatement pstmt=null;
        try
        {
            //连接数据库
            connection=getDataSource().getConnection();
            String sql="insert into student (id,name,sn) values(?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,stu.getId());
            pstmt.setString(2,stu.getName());
            pstmt.setInt(3,stu.getSn());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null){
                    pstmt.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    //查询学生表
    public static Student selectStu(int sn)
    {
        //获取数据源
        java.sql.Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Student stu=new Student();
        try
        {
            //连接数据库
            connection=getDataSource().getConnection();
            String sql="select * from student where sn=? ";
            pstmt = connection.prepareStatement(sql);
            System.out.println(pstmt);
            pstmt.setInt(1,sn);
            rs=pstmt.executeQuery();
            while(rs.next()){
                stu.setSn(rs.getInt("sn"));
                stu.setName(rs.getString("name"));
                stu.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null){
                    pstmt.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return stu;
    }
    //查询学生总人数
    public static Student selectStuCount()
    {
        //获取数据源
        java.sql.Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Student stu=new Student();
        try
        {
            //连接数据库
            connection=getDataSource().getConnection();
            String sql="select count(sn) as stu_number from student";
            pstmt = connection.prepareStatement(sql);
            System.out.println(pstmt);
            //pstmt.setInt(1,sn);
            rs=pstmt.executeQuery();
            while(rs.next()){
                /*stu.setSn(rs.getInt("sn"));
                stu.setName(rs.getString("name"));
                stu.setId(rs.getInt("id"));*/
                System.out.println("count="+rs.getInt("stu_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null){
                    pstmt.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return stu;
    }
    //插入班级表
    //查询班级表

    //插入课程表
    //查询课程表

    //
}
