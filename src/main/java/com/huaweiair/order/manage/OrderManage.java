
package com.huaweiair.order.manage;

import com.huaweiair.order.model.FlightFlag;
import com.huaweiair.order.model.Order;

public interface OrderManage {
  boolean createOrders(FlightFlag flightFlag);

  Order[] getAllOrders(String userId);

  boolean modifyOrder(String orderId, int action);

  boolean deleteOrder(String orderId);
}
