package com.ex.Objects;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="LISTS")
public class Lists {
    private int listId;
    private String listName;

    private double listTotal;


    private int listTotal;
    private User user;

    private List<Item> items;
    private User users;


    @ManyToOne
    @JoinColumn(name="USERID", nullable=false)
    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Lists{" +
                "listId=" + listId +
                ", listName='" + listName + '\'' +
                ", listTotal=" + listTotal +
                ", userId=" + users.getuserId() +
                '}';
    }

    public Lists() {}

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "LIST_JUNCTION", joinColumns ={@JoinColumn(name = "LISTID")}, inverseJoinColumns = {@JoinColumn(name = "ITEMID")})
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Id
    @Column(name = "LISTID")
    public int getlistId() {
        return listId;
    }

    public void setlistId(int listId) {
        this.listId = listId;
    }

    @Column(name = "LISTNAME")
    public String getlistName() {
        return listName;
    }

    public void setlistName(String listName) {
        this.listName = listName;
    }

    @Column(name = "LISTTOTAL")
    public double getlistTotal() {
        return listTotal;
    }

    public void setlistTotal(double listTotal) {
        this.listTotal = listTotal;
    }




    @ManyToOne
    @JoinColumn(name = "USERID", nullable=false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
