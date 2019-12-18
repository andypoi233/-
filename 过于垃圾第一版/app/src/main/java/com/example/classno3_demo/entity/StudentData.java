package com.example.classno3_demo.entity;
public class StudentData {
    private String name;   //定义学生的姓名
    private int age;       //定义学生的年龄
    private int photo;    //定义学生的照片

    public  void  setName(String name) {
        this.name = name;
    }

    public String getName() {
        return  name;
    }

    public  void  setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return  age;
    }

    public  void  setPhoto(int photo) {
        this.photo = photo;
    }

    public int getPhoto() {
        return  photo;
    }
}
