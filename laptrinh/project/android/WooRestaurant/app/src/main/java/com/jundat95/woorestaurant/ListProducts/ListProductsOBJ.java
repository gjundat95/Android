package com.jundat95.woorestaurant.ListProducts;

import android.graphics.Bitmap;

/**
 * Created by jundat95 on 24/03/2016.
 */
public class ListProductsOBJ {

    private int id;
    private String title;
    private String description;
    private String price;
    private String sale_price;
    private String average_rating;
    private int rating_count;
    private String categories;
    private String srcImage;
    private Bitmap bitmapImge;

    public ListProductsOBJ(){}
    public ListProductsOBJ(String average_rating, String categories, int id, String price, String description, String sale_price, int rating_count, String srcImage, String title) {
        this.average_rating = average_rating;
        this.categories = categories;
        this.id = id;
        this.price = price;
        this.description = description;
        this.sale_price = sale_price;
        this.rating_count = rating_count;
        this.srcImage = srcImage;
        this.title = title;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getBitmapImge() {
        return bitmapImge;
    }

    public void setBitmapImge(Bitmap bitmapImge) {
        this.bitmapImge = bitmapImge;
    }
}
