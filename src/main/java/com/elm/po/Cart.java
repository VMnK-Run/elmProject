package com.elm.po;

public class Cart {
    private Integer cartId;
    private Integer foodId;
    private Integer businessId;
    private String userId;
    private Integer quantity;

    //Many-to-One: Foods
    private Food food;
    //Many-to-one: Merchants
    private Business business;

    public Integer getCartId() {
        return cartId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Food getFood() {
        return food;
    }

    public Business getBusiness() {
        return business;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
