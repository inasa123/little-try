package com.vcl.life.Bean;

/**
 * 创建用户群体，将该类作为一个JavaBean类使用
 */
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer(String name, char gender, int age, String phone, String email) {
        //客户姓名
        this.name = name;
        //客户性别
        this.gender = gender;
        //客户年龄
        this.age = age;
        //客户电话
        this.phone = phone;
        //客户邮箱
        this.email = email;
    }
}
