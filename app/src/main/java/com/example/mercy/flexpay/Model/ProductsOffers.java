package com.example.mercy.flexpay.Model;

import com.google.gson.annotations.SerializedName;

public class ProductsOffers {
    @SerializedName("data")
    private String data;
    @SerializedName("id")
    private String id;
    @SerializedName("product_id")
    private String product_id;
    @SerializedName("offer_start_date")
    private String offer_start_date;
    @SerializedName("offer_end_date")
    private String offer_end_date;
    @SerializedName("offer_price")
    private String offer_price;
    @SerializedName("offer_quantity")
    private String offer_quantity;
    @SerializedName("product")
    private String product;
    @SerializedName("product_name")
    private String product_name;
    @SerializedName("errors")
    private String errors;
    @SerializedName("success")
    private String success;

    public ProductsOffers(String data, String id, String product_id, String offer_start_date, String offer_end_date, String offer_price, String offer_quantity, String product, String product_name, String errors, String success) {
        this.data = data;
        this.id = id;
        this.product_id = product_id;
        this.offer_start_date = offer_start_date;
        this.offer_end_date = offer_end_date;
        this.offer_price = offer_price;
        this.offer_quantity = offer_quantity;
        this.product = product;
        this.product_name = product_name;
        this.errors = errors;
        this.success = success;
    }

    public String getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getOffer_start_date() {
        return offer_start_date;
    }

    public String getOffer_end_date() {
        return offer_end_date;
    }

    public String getOffer_price() {
        return offer_price;
    }

    public String getOffer_quantity() {
        return offer_quantity;
    }

    public String getProduct() {
        return product;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getErrors() {
        return errors;
    }

    public String getSuccess() {
        return success;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setOffer_start_date(String offer_start_date) {
        this.offer_start_date = offer_start_date;
    }

    public void setOffer_end_date(String offer_end_date) {
        this.offer_end_date = offer_end_date;
    }

    public void setOffer_price(String offer_price) {
        this.offer_price = offer_price;
    }

    public void setOffer_quantity(String offer_quantity) {
        this.offer_quantity = offer_quantity;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
