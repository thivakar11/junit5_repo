package com.pack;

public class DataBase
{
    public DataBase(String name, String num, String email, String password) {
        this.name = name;
        this.num = num;
        this.email = email;
        this.password = password;
    }
    private String name;
    private String num;
    private String email;
    private String password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
