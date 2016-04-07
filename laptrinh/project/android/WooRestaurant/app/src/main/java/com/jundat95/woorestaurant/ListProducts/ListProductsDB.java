package com.jundat95.woorestaurant.ListProducts;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jundat95 on 06/04/2016.
 */
public class ListProductsDB implements Serializable {

    private ArrayList<ListProductsOBJ> dbs = new ArrayList<ListProductsOBJ>();

    public ArrayList<ListProductsOBJ> getDbs() {
        return dbs;
    }

    public void addDbs(ListProductsOBJ dbs) {
        this.dbs.add(dbs);
    }
}
