package com.bit.main;

import com.bit.data.Student;
import com.bit.db.DatabaseOperator;

import java.util.Scanner;

public class CourseSystem {
    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        Student stu=new Student();
        stu.setSn(40008);
        stu.setName("link");
        stu.setId(3);
        DatabaseOperator.insertStu(stu);
        Student stu2=DatabaseOperator.selectStu(40001);
        DatabaseOperator.selectStuCount();
    }
}
