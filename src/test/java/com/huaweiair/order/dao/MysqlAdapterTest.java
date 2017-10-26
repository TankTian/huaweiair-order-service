
package com.huaweiair.order.dao;

import static org.junit.Assert.*;
import org.junit.Test;

import com.huaweiair.order.model.Order;

public class MysqlAdapterTest {
  @Test
  public void testDb() {
    Order order = new Order();
    order.setOrderId("tank01");
    order.setUserId("tanktank");
    order.setFlightId("1111111");
    order.setName("北京-天津");
    order.setScheduledDepartureTime("2012");
    order.setScheduledArrivalTime("2017");
    order.setFlightClass(2);
    order.setFlightPrice(333);
    order.setOrderTime("2013");
    order.setOrderStatus(3);
    MysqlOrderDbAdapterImpl mysqlAdapter = new MysqlOrderDbAdapterImpl("49.4.2.165", 30006);
    mysqlAdapter.deleteOrder(order.getOrderId());
    mysqlAdapter.insertOrder(order);

    order.setOrderId("tank02");
    order.setName("上海-深圳");
    mysqlAdapter.deleteOrder(order.getOrderId());
    mysqlAdapter.insertOrder(order);
    mysqlAdapter.updateOrder(order.getOrderId(), 9);
    Order[] orders = mysqlAdapter.queryOrders(order.getUserId());
    for(Order orderTem :orders)
    {
      boolean isExist=false;
      if(orderTem.getOrderId().equals("tank01"))
      {
        assertEquals("北京-天津", orderTem.getName());
        isExist=true;
      }
      if(orderTem.getOrderId().equals("tank02"))
      {
        assertEquals("上海-深圳", orderTem.getName());
        isExist=true;
      }
      assertTrue(isExist);
    }

  }
}
