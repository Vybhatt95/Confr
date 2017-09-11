package com.p2.Objects;


import javax.persistence.*;

@Entity
@Table(name="Lists")
public class Lists {
    private int listid;
    private String listname;
    private int listtotal;
    private int userid;


    @Id
    @Column(name = "Listid")
    @ManyToMany
    @JoinTable()
    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }

    @Column(name = "Listname")
    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    @Column(name = "Listtotal")
    public int getListtotal() {
        return listtotal;
    }

    public void setListtotal(int listtotal) {
        this.listtotal = listtotal;
    }

    @Column(name = "Userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
