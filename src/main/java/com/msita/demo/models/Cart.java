package com.msita.demo.models;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> cartItems ;

    public Cart() {
        this.cartItems = new ArrayList<CartItem>();
    }

    public  void  addCartItem(CartItem cartItem){
        this.cartItems.add(cartItem);
    }
    public  void  removeCartItem(Integer id){
    for(int i = 0;i<this.cartItems.size();++i){
        if(this.cartItems.get(i).getProduct().getId() == id ){
            this.cartItems.remove(i);
            return;
        }
      }
    }
    public CartItem getCartItemByProductId(Integer id){
        for (int i =0;i<this.cartItems.size();++i){
            if (this.cartItems.get(i).getProduct().getId() == (id)) {
                return this.cartItems.get(i);}

        }
        return null;
    }


public  ArrayList<CartItem> getCartItems(){
        return  cartItems;
}
}
