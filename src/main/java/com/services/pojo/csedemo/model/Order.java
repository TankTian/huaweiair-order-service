
package com.services.pojo.csedemo.model;

public class Order {

  private String orderId;
  private String userId;
  private String flightId;
  private String name;
  private String flightTime;
  private int flightClass;
  private int flightPrice;
  private String orderTime;
  private int orderStatus;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getFlightId() {
    return flightId;
  }

  public void setFlightId(String flightId) {
    this.flightId = flightId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFlightTime() {
    return flightTime;
  }

  public void setFlightTime(String flightTime) {
    this.flightTime = flightTime;
  }

  public int getFlightClass() {
    return flightClass;
  }

  public void setFlightClass(int flightClass) {
    this.flightClass = flightClass;
  }

  public int getFlightPrice() {
    return flightPrice;
  }

  public void setFlightPrice(int flightPrice) {
    this.flightPrice = flightPrice;
  }

  public String getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(String orderTime) {
    this.orderTime = orderTime;
  }

  public int getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(int orderStatus) {
    this.orderStatus = orderStatus;
  }

}
