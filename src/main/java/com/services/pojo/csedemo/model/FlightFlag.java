
package com.services.pojo.csedemo.model;

public class FlightFlag {
  private String userId;
  private String originPort;
  private String destPort;
  private String toFlightId;
  private String toFlightTime;
  private int toFlightClass;
  private int toFlightPrice;
  private String returnFlightId;
  private int returnFlightClass;
  private String returnFlightTime;
  private int returnFlightPrice;

  public String getToFlightTime() {
    return toFlightTime;
  }

  public void setToFlightTime(String toFlightTime) {
    this.toFlightTime = toFlightTime;
  }

  public int getToFlightPrice() {
    return toFlightPrice;
  }

  public void setToFlightPrice(int toFlightPrice) {
    this.toFlightPrice = toFlightPrice;
  }

  public String getReturnFlightTime() {
    return returnFlightTime;
  }

  public void setReturnFlightTime(String returnFlightTime) {
    this.returnFlightTime = returnFlightTime;
  }

  public int getReturnFlightPrice() {
    return returnFlightPrice;
  }

  public void setReturnFlightPrice(int returnFlightPrice) {
    this.returnFlightPrice = returnFlightPrice;
  }

  public String getOriginPort() {
    return originPort;
  }

  public void setOriginPort(String originPort) {
    this.originPort = originPort;
  }

  public String getDestPort() {
    return destPort;
  }

  public void setDestPort(String destPort) {
    this.destPort = destPort;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getToFlightId() {
    return toFlightId;
  }

  public void setToFlightId(String toFlightId) {
    this.toFlightId = toFlightId;
  }

  public int getToFlightClass() {
    return toFlightClass;
  }

  public void setToFlightClass(int toFlightClass) {
    this.toFlightClass = toFlightClass;
  }

  public String getReturnFlightId() {
    return returnFlightId;
  }

  public void setReturnFlightId(String returnFlightId) {
    this.returnFlightId = returnFlightId;
  }

  public int getReturnFlightClass() {
    return returnFlightClass;
  }

  public void setReturnFlightClass(int returnFlightClass) {
    this.returnFlightClass = returnFlightClass;
  }


}
