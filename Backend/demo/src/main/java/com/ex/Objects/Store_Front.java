package com.ex.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORE_FRONT")
public class Store_Front {
    private int storeId;
    private String storeName;
    private String storeAddress;
    private String storeCity;
    private String storeState;
    private String storeZip;


    public Store_Front() {}

    @Override
    public String toString() {
        return "Store_Front{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeCity='" + storeCity + '\'' +
                ", storeState='" + storeState + '\'' +
                ", storeZip='" + storeZip + '\'' +
                '}';
    }



    @Id
    @Column(name = "STOREID")
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Column(name = "STORENAME")
    public String getstoreName() {
        return storeName;
    }

    public void setstoreName(String storeName) {
        this.storeName = storeName;
    }

    @Column(name = "STOREADDRESS")
    public String getstoreAddress() {
        return storeAddress;
    }

    public void setstoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    @Column(name="STORECITY")
    public String getstoreCity() {
        return storeCity;
    }

    public void setstoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    @Column(name = "STORESTATE")
    public String getstoreState() {
        return storeState;
    }

    public void setstoreState(String storeState) {
        this.storeState = storeState;
    }

    @Column(name = "STOREZIP")
    public String getstoreZip() {
        return storeZip;
    }

    public void setstoreZip(String storeZip) {
        this.storeZip = storeZip;
    }
}
