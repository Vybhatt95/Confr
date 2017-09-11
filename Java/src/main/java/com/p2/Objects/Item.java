package com.p2.Objects;


import javax.persistence.*;

@Entity
@Table(name="Item")
public class Item {
    private int itemid;
    private String itemname;
    private String itemprice;
    private int barcode;

    public Item(){}


    @Id
    @Column(name="Itemid")
    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    @Column(name="Itemname")
    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    @Column(name="Itemprice")
    public String getItemprice() {
        return itemprice;
    }

    public void setItemprice(String itemprice) {
        this.itemprice = itemprice;
    }

    @Column(name="Barcode")
    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
}
