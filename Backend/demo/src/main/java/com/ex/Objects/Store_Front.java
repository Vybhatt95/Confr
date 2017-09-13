package com.ex.Objects;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STORE_FRONT")
public class Store_Front {
    private int storeId;
    private String storeName;
    private String storeAddress;
    private String storeCity;
    private String storeState;
    private int storeZip;


    @Override
    public String toString() {
        return "Store_Front{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeCity='" + storeCity + '\'' +
                ", storeState='" + storeState + '\'' +
                ", storeZip=" + storeZip +
                '}';
    }

    @Id
    @GenericGenerator(name="storeIdGen",strategy = "increment")
    @GeneratedValue(generator = "storeIdGen")
    @Column(name = "STOREID")
    public int getstoreId() {
        return storeId;
    }

    public void setstoreId(int storeId) {
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
    public int getstoreZip() {
        return storeZip;
    }

    public void setstoreZip(int storeZip) {
        this.storeZip = storeZip;
    }
}
