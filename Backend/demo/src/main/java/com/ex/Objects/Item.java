package com.ex.Objects;


import javax.persistence.*;

@Entity
@Table(name="ITEM")
public class Item {
    private int itemId;
    private String itemName;
    private String itemPrice;
    private int barcode;

    public Item(){}


    @Id
    @Column(name="ITEMID")
    public int getitemId() {
        return itemId;
    }

    public void setitemId(int itemId) {
        this.itemId = itemId;
    }

    @Column(name="ITEMNAME")
    public String getitemName() {
        return itemName;
    }

    public void setitemName(String itemName) {
        this.itemName = itemName;
    }

    @Column(name="ITEMPRICE")
    public String getitemPrice() {
        return itemPrice;
    }

    public void setitemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Column(name="BARCODE")
    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
}
