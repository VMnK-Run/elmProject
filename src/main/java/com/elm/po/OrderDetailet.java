package com.elm.po;

public class OrderDetailet {
    private Integer odId;
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;

    //Many-to-One: Foods
    private Food food;

    public Integer getOdId() {
        return odId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
