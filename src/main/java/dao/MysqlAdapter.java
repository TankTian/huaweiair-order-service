
package dao;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
  private static String tableName = "huaweiair_order";
  private static String dbUrl = "jdbc:mysql://10.229.44.124:3306/"+tableName+"";
  private static String dbUserName = "root";
  private static String dbPassword = "huawei@123";
  private static String jdbcName = "com.mysql.jdbc.Driver";
 


  private static Statement stmt;

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
      con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
      System.out.println("数据库连接成功");

      stmt = con.createStatement();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {
    
    String xmString = new String("北京".toString().getBytes("UTF-8"));  
    System.out.println(xmString) ;  
    String  xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");  
    System.out.println("utf-8 编码：" + xmlUTF8) ;  
//      xmlUTF8 = URLEncoder.encode(xmlUTF8, "UTF-8"); 
    System.out.println("utf-8 编码：" + new String(xmlUTF8.getBytes(),"UTF-8")) ;  
      xmString =  URLDecoder.decode(xmlUTF8, "UTF-8");
//      xmlUTF8 = URLEncoder.(xmlUTF8, "GBK");  
//    System.out.println("utf-8 编码：" + URLDecoder.decode(xmlUTF8, "UTF-8");) ;  
    
    
    Order order = new Order();
    order.setOrderId("11111");
    order.setUserId("tanktank");
    order.setFlightId("1111111");
    order.setName(xmlUTF8);
    order.setFlightTime("2017");
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
    System.out.println("utf-8 编码：" + URLDecoder.decode(orders[0].getName(), "UTF-8")) ;  

  }

  @Override
  public boolean insertOrder(Order order) {
    String sql = "INSERT INTO "+tableName+" VALUES ('" + order.getOrderId() + "', " + "'" + order.getUserId() + "', '"
        + order.getFlightId() + "', '" + order.getName() + "', '" + order.getFlightTime() + "', '"
        + order.getFlightClass() + "', '" + order.getFlightPrice() + "', '" + order.getOrderTime() + "', '"
        + order.getOrderStatus() + "')";
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
    String sql = "UPDATE "+tableName+" SET orderstatus='" + action + "'  WHERE orderId='" + orderId + "'";
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
    String sql = "DELETE FROM "+tableName+" WHERE orderId='" + orderId + "'";
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
    String sql = "SELECT * FROM "+tableName+" WHERE userId='" + userId + "'";
    try {
      System.out.println(sql);
      ResultSet re = stmt.executeQuery(sql);
      try {
        List<?> reList = populate(re, Order.class);
        return (Order[]) reList.toArray(new Order[] {new Order()});
      } catch (InstantiationException | IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
