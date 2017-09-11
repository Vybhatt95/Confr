package com.ex.Objects;


import javax.persistence.*;

@Entity
@Table(name="ITEM")
public class Item {
    private int itemId;
    private String itemName;
    private double itemPrice;
    private int barcode;

    private Store_Front stores;

    public Item(){}


    @OneToOne
    @JoinColumn(name = "STOREID")
    public Store_Front getStores() {
        return stores;
    }

    public void setStores(Store_Front stores) {
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", barcode=" + barcode +
                '}';
    }

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
    public double getitemPrice() {
        return itemPrice;
    }

    public void setitemPrice(double itemPrice) {
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
