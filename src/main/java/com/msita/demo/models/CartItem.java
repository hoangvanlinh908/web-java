package com.msita.demo.models;
public class CartItem {
    private ProductModel product;
    private Integer number1;
    private Float totalPrice;




    public CartItem(ProductModel product, Integer number1, Float totalPrice) {
        this.product = product;
        this.number1 = number1;
        this.totalPrice = totalPrice;

    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number) {
        this.number1= number;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}