package com.finance.richard.financebook;

/**
 * Created by richard on 7/27/2015.
 */
public class Purchase {

    public static final String TABLE = "Purchase";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_PRICE = "Price";


    //item, shop, quantity, time
    private float mPrice;
    private String mName;


    public Purchase(){
        mPrice = 0;
        mName = "";
    }

    public float getPrice() {
        return mPrice;
    }

    public String getName() {
        return mName;
    }

    public Purchase setPrice(float price){
        mPrice = price;
        return this;
    }

    public Purchase setName(String description){
        mName = description;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(mName);
        s.append(" is $");
        s.append(String.valueOf(mPrice));
        return s.toString();
    }
}


