
package dao;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.services.pojo.csedemo.model.Order;

/**
 * 
 * mysql -uroot -phuawei@123; use "+tableName+"; select * from "+tableName+";
 * 
 * 
 * create database huaweiair_order; CREATE TABLE "+tableName+" ( orderId varchar(255), flightId
 * varchar(255), name varchar(255), flightTime varchar(255), flightClass int, flightPrice int,
 * orderTime varchar(255), orderStatus int, PRIMARY KEY (orderId) );
 * 
 * <br/>
 * <p>
 * </p>
 * 
 * @author tank
 */
public class MysqlAdapter implements DbAdapter {
  private static String databaseName = "huaweiair_order";
  private static String tableName = "huaweiair_order";
  private static String dbUrl = "jdbc:mysql://mysql:30006/";
  private static String dbUserName = "root";
  private static String dbPassword = "huawei@123";
  private static String jdbcName = "com.mysql.jdbc.Driver";



  private static Statement stmt;

  /**
   * 当数据库不存在就创建库，初始化表 <br/>
   * 
   * @param stmt
   */
  private void initDb(Statement stmt) {
    try {
      stmt.execute("use " + databaseName);
    } catch (SQLException e) {
      if (e instanceof MySQLSyntaxErrorException) {
        if (e.getMessage().contains("Unknown database")) {
          try {
            stmt.execute("create database " + databaseName);
            stmt.execute("use " + databaseName);
            stmt.execute("CREATE TABLE " + tableName
                + " ( orderId varchar(255),userId varchar(255), flightId varchar(255), name varchar(255), scheduledDepartureTime varchar(255), scheduledArrivalTime varchar(255), flightClass int, flightPrice int, orderTime varchar(255), orderStatus int, PRIMARY KEY (orderId) ) ");
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
      }
    }
  }

  public MysqlAdapter() {
    try {
      Class.forName(jdbcName);
      System.out.println("驱动加载成功");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.out.println("驱动加载失败");
    }
    Connection con = null;
    try {
      System.out.println("获取数据库连接开始");
      con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
      System.out.println("数据库连接成功");
      stmt = con.createStatement();
      initDb(stmt);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {

    Order order = new Order();
    order.setOrderId("11111");
    order.setUserId("tanktank");
    order.setFlightId("1111111");
    order.setName("北京");
    order.setScheduledDepartureTime("2012");
    order.setScheduledArrivalTime("2017");
    order.setFlightClass(2);
    order.setFlightPrice(333);
    order.setOrderTime("2013");
    order.setOrderStatus(3);
    new MysqlAdapter().deleteOrder(order.getOrderId());
    new MysqlAdapter().insertOrder(order);
    order.setOrderId("22tank");
    new MysqlAdapter().deleteOrder(order.getOrderId());
    new MysqlAdapter().insertOrder(order);
    new MysqlAdapter().updateOrder(order.getOrderId(), 9);
    Order[] orders = new MysqlAdapter().queryOrders(order.getUserId());
    System.out.println(orders);
    System.out.println(orders[0].getFlightId());
    System.out.println(orders[0].getName());
    System.out.println("utf-8 编码：" + URLDecoder.decode(orders[0].getName(), "UTF-8"));

  }

  @Override
  public boolean insertOrder(Order order) {
    String sql = "INSERT INTO " + tableName + " VALUES ('" + order.getOrderId() + "', " + "'" + order.getUserId()
        + "', '" + order.getFlightId() + "', '" + order.getName() + "', '" + order.getScheduledDepartureTime() + "', '"
        + order.getScheduledArrivalTime() + "', '" + order.getFlightClass() + "', '" + order.getFlightPrice() + "', '"
        + order.getOrderTime() + "', '" + order.getOrderStatus() + "')";
    try {
      System.out.println(sql);
      stmt.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }


  @Override
  public boolean updateOrder(String orderId, int action) {
    String sql = "UPDATE " + tableName + " SET orderstatus='" + action + "'  WHERE orderId='" + orderId + "'";
    try {
      System.out.println(sql);
      stmt.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean deleteOrder(String orderId) {
    String sql = "DELETE FROM " + tableName + " WHERE orderId='" + orderId + "'";
    try {
      System.out.println(sql);
      stmt.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public Order[] queryOrders(String userId) {
    String sql = "SELECT * FROM " + tableName + " WHERE userId='" + userId + "'";
    try {
      System.out.println(sql);
      ResultSet re = stmt.executeQuery(sql);
      try {
        List<?> reList = populate(re, Order.class);
        if (null == reList || reList.isEmpty()) {
          return new Order[] {};
        }
        return (Order[]) reList.toArray(new Order[] {new Order()});
      } catch (InstantiationException | IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return new Order[] {};
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return new Order[] {};
  }
}
