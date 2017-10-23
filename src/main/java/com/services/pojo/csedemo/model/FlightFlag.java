
package com.services.pojo.csedemo.model;

public class FlightFlag {
  private String userId;
  private String fromAirPortName;
  private String toAirPortName;
  private String toFlightId;
  private String toFlightTime;
  private String toScheduledDepartureTime;
  private String toScheduledArrivalTime;
  private int toFlightClass;
  private int toFlightPrice;
  private String retFlightId;
  private int retFlightClass;
  private String retFlightTime;
  private String toFlightSegId;
  private String retFlightSegId;
  private boolean oneWayFlight;
  private String retScheduledArrivalTime;
  private String retScheduledDepartureTime;
  
  public String getToScheduledDepartureTime() {
    return toScheduledDepartureTime;
  }

  public void setToScheduledDepartureTime(String toScheduledDepartureTime) {
    this.toScheduledDepartureTime = toScheduledDepartureTime;
  }

  public String getToScheduledArrivalTime() {
    return toScheduledArrivalTime;
  }

  public void setToScheduledArrivalTime(String toScheduledArrivalTime) {
    this.toScheduledArrivalTime = toScheduledArrivalTime;
  }

  public String getRetScheduledArrivalTime() {
    return retScheduledArrivalTime;
  }

  public void setRetScheduledArrivalTime(String retScheduledArrivalTime) {
    this.retScheduledArrivalTime = retScheduledArrivalTime;
  }

  public String getRetScheduledDepartureTime() {
    return retScheduledDepartureTime;
  }

  public void setRetScheduledDepartureTime(String retScheduledDepartureTime) {
    this.retScheduledDepartureTime = retScheduledDepartureTime;
  }

  public String getRetFlightSegId() {
    return retFlightSegId;
  }

  public void setRetFlightSegId(String retFlightSegId) {
    this.retFlightSegId = retFlightSegId;
  }

  public String getToFlightSegId() {
    return toFlightSegId;
  }

  public void setToFlightSegId(String toFlightSegId) {
    this.toFlightSegId = toFlightSegId;
  }

  public boolean isOneWayFlight() {
    return oneWayFlight;
  }

  public void setOneWayFlight(boolean oneWayFlight) {
    this.oneWayFlight = oneWayFlight;
  }

  public String getRetFlightId() {
    return retFlightId;
  }

  public void setRetFlightId(String retFlightId) {
    this.retFlightId = retFlightId;
  }

  public int getRetFlightClass() {
    return retFlightClass;
  }

  public void setRetFlightClass(int retFlightClass) {
    this.retFlightClass = retFlightClass;
  }

  public String getRetFlightTime() {
    return retFlightTime;
  }

  public void setRetFlightTime(String retFlightTime) {
    this.retFlightTime = retFlightTime;
  }

  public int getRetFlightPrice() {
    return retFlightPrice;
  }

  public void setRetFlightPrice(int retFlightPrice) {
    this.retFlightPrice = retFlightPrice;
  }

  private int retFlightPrice;

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


  public String getFromAirPortName() {
    return fromAirPortName;
  }

  public void setFromAirPortName(String fromAirPortName) {
    this.fromAirPortName = fromAirPortName;
  }

  public String getToAirPortName() {
    return toAirPortName;
  }

  public void setToAirPortName(String toAirPortName) {
    this.toAirPortName = toAirPortName;
  }



}
