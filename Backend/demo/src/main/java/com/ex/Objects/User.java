package com.ex.Objects;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERINFO")
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private String email;
    private List<Lists> lists;

    public User() {}
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Id
    @GenericGenerator(name="userIdGen",strategy = "increment")
    @GeneratedValue(generator = "userIdGen")
    @Column(name = "USERID")
    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "FIRSTNAME")
    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name ="LASTNAME")
    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "USERNAME")
    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PASS_WORD")
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @OneToMany(mappedBy = "user",fetch=FetchType.EAGER)
    public List<Lists> getLists(){
        return lists;
    }

    public void setLists(List<Lists> lists){
        this.lists = lists;
    }
}
