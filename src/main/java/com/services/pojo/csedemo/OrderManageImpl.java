
package com.services.pojo.csedemo;

import com.services.pojo.csedemo.model.FlightFlag;
import com.services.pojo.csedemo.model.Order;

import io.servicecomb.provider.pojo.RpcSchema;

@RpcSchema(schemaId = "order")
public class OrderManageImpl implements OrderManage {
  private OrderManage orderManage = new OrderManageAgent();

  @Override
  public boolean createOrders(FlightFlag flightFlag) {
    return orderManage.createOrders(flightFlag);
  }

  @Override
  public Order[] getAllOrders(String userId) {
    return orderManage.getAllOrders(userId);
  }

  @Override
  public boolean modifyOrder(String orderId, int action) {
    return orderManage.modifyOrder(orderId, action);
  }

  @Override
  public boolean deleteOrder(String orderId) {
    return orderManage.deleteOrder(orderId);
  }

}
