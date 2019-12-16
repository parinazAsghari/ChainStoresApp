package com.example.parinaz.chainstoresapp.roomdb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by parinaz on 11/18/19.
 */
@Entity(tableName = "marked_products")
public class markedEntity {

    @PrimaryKey(autoGenerate = true)
    public int  id;

    @ColumnInfo(name="code")
    public int product_code;

 @ColumnInfo(name="name")
    public String product_name;

 @ColumnInfo(name="price")
    public int product_price;

 @ColumnInfo(name="discount")
    public int product_discount;

 @ColumnInfo(name="reducedprice")
    public int product_reducedprice;

 @ColumnInfo(name="category")
    public int product_category;

 @ColumnInfo(name="image")
   public String product_image;

 @ColumnInfo(name="storeicon")
    public String product_storeicon;


    @ColumnInfo(name="storename")
    public String product_storename;

    @ColumnInfo(name="branchid")
    public int product_branchid;

    @ColumnInfo(name="stock")
    public int product_stock;


    public int getProduct_code() {
        return product_code;
    }

    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(int product_discount) {
        this.product_discount = product_discount;
    }

    public int getProduct_reducedprice() {
        return product_reducedprice;
    }

    public void setProduct_reducedprice(int product_reducedprice) {
        this.product_reducedprice = product_reducedprice;
    }

    public int getProduct_category() {
        return product_category;
    }

    public void setProduct_category(int product_category) {
        this.product_category = product_category;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
       this.product_image = product_image;
    }

    public String getProduct_storeicon() {
        return product_storeicon;
    }

    public void setProduct_storeicon(String product_storeicon) {
        this.product_storeicon = product_storeicon;
    }

    public String getProduct_storename() {
        return product_storename;
    }

    public void setProduct_storename(String product_storename) {
        this.product_storename = product_storename;
    }

    public int getProduct_branchid() {
        return product_branchid;
    }

    public void setProduct_branchid(int product_branchid) {
        this.product_branchid = product_branchid;
    }

    public int getProduct_stock() {
        return product_stock;
    }


    public void setProduct_stock(int product_stock) {
        this.product_stock = product_stock;
    }
}
