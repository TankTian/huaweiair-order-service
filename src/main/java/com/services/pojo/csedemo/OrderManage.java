
package com.services.pojo.csedemo;

import com.services.pojo.csedemo.model.FlightFlag;
import com.services.pojo.csedemo.model.Order;

public interface OrderManage {
  boolean createOrders(FlightFlag flightFlag);

  Order[] getAllOrders(String userId);

  boolean modifyOrder(String orderId, int action);

  boolean deleteOrder(String orderId);
}
