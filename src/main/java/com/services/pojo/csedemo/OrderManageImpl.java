
package com.services.pojo.csedemo;

import com.services.pojo.csedemo.model.FlightFlag;
import com.services.pojo.csedemo.model.Order;

import io.servicecomb.provider.pojo.RpcSchema;

@RpcSchema(schemaId = "order")
public class OrderManageImpl implements OrderManage {

  @Override
  public boolean createOrders(FlightFlag flightFlag) {
    return true;
  }

  @Override
  public Order[] getAllOrders() {
    // TODO Auto-generated method stub
    return new Order[]{new Order()};
  }

  @Override
  public boolean modifyOrder(String orderId, int action) {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean deleteOrder(String orderId) {
    // TODO Auto-generated method stub
    return true;
  }

}
