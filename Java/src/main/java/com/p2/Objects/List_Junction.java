package com.p2.Objects;


import javax.persistence.*;

@Entity
@Table(name="List_Junction")
public class List_Junction {
    private int itemid;
    private int listid;


    @Column(name="Itemid")
    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    @Column(name="Listid")
    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }
}
