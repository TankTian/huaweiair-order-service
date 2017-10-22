
package com.services.pojo.csedemo;

import java.util.UUID;

import com.services.pojo.csedemo.model.FlightFlag;
import com.services.pojo.csedemo.model.Order;

import dao.DbAdapter;
import dao.MysqlAdapter;

/**
 * 
 * <br/>
 * <p>
 * </p>
 * 
 * @author tank tian
 */
public class OrderManageAgent implements OrderManage {
  private DbAdapter dbAdapter = new MysqlAdapter();

  /**
   * <br/>
   * 
   * @param flightFlag
   * @return
   */
  @Override
  public boolean createOrders(FlightFlag flightFlag) {
//todo 航班号是确定一趟航班 如果航班中间停怎么办？？ 什么来标识路段？？？segment
    boolean flagOne = false;
    boolean flagTwo = false;
    if (null != flightFlag.getToFlightId() && !flightFlag.getToFlightId().isEmpty()) {
      Order toFlightOrder = new Order();
      toFlightOrder.setUserId(flightFlag.getUserId());
      toFlightOrder.setOrderId(UUID.randomUUID().toString());
      toFlightOrder.setFlightId(flightFlag.getToFlightId());
      toFlightOrder.setName(flightFlag.getOriginPort()+"-"+flightFlag.getDestPort());
      toFlightOrder.setFlightTime(flightFlag.getToFlightTime());
      toFlightOrder.setFlightClass(flightFlag.getToFlightClass());
      toFlightOrder.setFlightPrice(flightFlag.getToFlightPrice());
      toFlightOrder.setOrderTime("" + System.currentTimeMillis());
      toFlightOrder.setOrderStatus(0);
      flagOne = dbAdapter.insertOrder(toFlightOrder);
    }
    if (null != flightFlag.getReturnFlightId() && !flightFlag.getReturnFlightId().isEmpty()) {
      Order returnFlightOrder = new Order();
      returnFlightOrder.setUserId(flightFlag.getUserId());
      returnFlightOrder.setOrderId(UUID.randomUUID().toString());
      returnFlightOrder.setFlightId(flightFlag.getReturnFlightId());
      returnFlightOrder.setName(flightFlag.getDestPort()+"-"+flightFlag.getOriginPort());
      returnFlightOrder.setFlightTime(flightFlag.getReturnFlightTime());
      returnFlightOrder.setFlightClass(flightFlag.getReturnFlightClass());
      returnFlightOrder.setFlightPrice(flightFlag.getReturnFlightPrice());
      returnFlightOrder.setOrderTime("" + System.currentTimeMillis());
      returnFlightOrder.setOrderStatus(0);

      flagTwo = dbAdapter.insertOrder(returnFlightOrder);
    }
    return flagOne && flagTwo;
  }

  @Override
  public Order[] getAllOrders(String userId) {
    return dbAdapter.queryOrders(userId);
  }

  @Override
  public boolean modifyOrder(String orderId, int action) {
    return dbAdapter.updateOrder(orderId, action);
  }

  @Override
  public boolean deleteOrder(String orderId) {
    return dbAdapter.deleteOrder(orderId);
  }

}