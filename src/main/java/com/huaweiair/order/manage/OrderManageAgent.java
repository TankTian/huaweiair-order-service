
package com.huaweiair.order.manage;

import java.util.UUID;

import com.huaweiair.order.dao.OrderDbAdapter;
import com.huaweiair.order.dao.MysqlOrderDbAdapterImpl;
import com.huaweiair.order.model.FlightFlag;
import com.huaweiair.order.model.Order;

/**
 * 
 * <br/>
 * <p>
 * </p>
 * 
 * @author tank tian
 */
public class OrderManageAgent implements OrderManage {
  private OrderDbAdapter dbAdapter;

  public OrderManageAgent() {
    String ip = System.getenv("MYSQL_IP");
    String port = System.getenv("MYSQL_PORT");
    dbAdapter =
        new MysqlOrderDbAdapterImpl(null != ip ? ip : "mysql", null != port ? Integer.parseInt(port) : 30006);

  }

  /**
   * <br/>
   * 
   * @param flightFlag
   * @return
   */
  @Override
  public boolean createOrders(FlightFlag flightFlag) {
    // todo 航班号是确定一趟航班 如果航班中间停怎么办？？ 什么来标识路段？？？segment
    boolean flagOne = false;
    boolean flagTwo = false;
    if (null != flightFlag.getToFlightId() && !flightFlag.getToFlightId().isEmpty()) {
      Order toFlightOrder = new Order();
      toFlightOrder.setUserId(flightFlag.getUserId());
      toFlightOrder.setOrderId(UUID.randomUUID().toString());
      toFlightOrder.setFlightId(flightFlag.getToFlightId());
      toFlightOrder.setName(flightFlag.getFromAirPortName() + "-" + flightFlag.getToAirPortName());
      toFlightOrder.setScheduledDepartureTime(flightFlag.getToScheduledDepartureTime());
      toFlightOrder.setScheduledArrivalTime(flightFlag.getToScheduledArrivalTime());
      toFlightOrder.setFlightClass(flightFlag.getToFlightClass());
      toFlightOrder.setFlightPrice(flightFlag.getToFlightPrice());
      toFlightOrder.setOrderTime("" + System.currentTimeMillis());
      toFlightOrder.setOrderStatus(0);
      flagOne = dbAdapter.insertOrder(toFlightOrder);
    }
    if (null != flightFlag.getRetFlightId() && !flightFlag.getRetFlightId().isEmpty()) {
      Order returnFlightOrder = new Order();
      returnFlightOrder.setUserId(flightFlag.getUserId());
      returnFlightOrder.setOrderId(UUID.randomUUID().toString());
      returnFlightOrder.setFlightId(flightFlag.getRetFlightId());
      returnFlightOrder.setName(flightFlag.getToAirPortName() + "-" + flightFlag.getFromAirPortName());
      returnFlightOrder.setScheduledDepartureTime(flightFlag.getRetScheduledDepartureTime());
      returnFlightOrder.setScheduledArrivalTime(flightFlag.getRetScheduledArrivalTime());
      returnFlightOrder.setFlightClass(flightFlag.getRetFlightClass());
      returnFlightOrder.setFlightPrice(flightFlag.getRetFlightPrice());
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
