/*29.08.2017*/
package com.epam.courses.jf.practice.filippov.collections;

public class Order implements Comparable<Order>{

    private int orderID;
    private int customerID;
    private String product;

    public Order(int orderID, int customerID, String product) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.product = product;
    }

    @Override
    public int compareTo(Order other) {
        if (this.getOrderID() > other.getOrderID()) {
            return 1;
        } else if (this.getOrderID() == other.getOrderID()) {
            return 0;
        } return -1;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
