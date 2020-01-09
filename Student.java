package com.bit.data;

public class Student {
    private int sn;
    private String name;
    private int id;
    public int getSn() {

        return sn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sn=" + sn +
                ", name='" + name + '\'' +
                ", classid=" + id +
                '}';
    }
}
