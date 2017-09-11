package com.p2.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Store_Front")
public class Store_Front {
    private int storeid;
    private String storename;
    private String storeaddress;
    private String storecity;
    private String storestate;
    private String storezip;

    @Id
    @Column(name = "Storeid")
    public int getStoreid() {
        return storeid;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }

    @Column(name = "Storename")
    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    @Column(name = "Storeaddress")
    public String getStoreaddress() {
        return storeaddress;
    }

    public void setStoreaddress(String storeaddress) {
        this.storeaddress = storeaddress;
    }

    @Column(name="Storecity")
    public String getStorecity() {
        return storecity;
    }

    public void setStorecity(String storecity) {
        this.storecity = storecity;
    }

    @Column(name = "Storestate")
    public String getStorestate() {
        return storestate;
    }

    public void setStorestate(String storestate) {
        this.storestate = storestate;
    }

    @Column(name = "Storezip")
    public String getStorezip() {
        return storezip;
    }

    public void setStorezip(String storezip) {
        this.storezip = storezip;
    }
}
