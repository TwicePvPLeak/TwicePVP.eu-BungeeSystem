package de.Feuerwolf1.TwicePvPBungeeSystem.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL
{
  public static String host = "212.224.126.91";
  public static int port = 3306;
  public static String username = "twicepvp";
  public static String password = "kWBCK8AqDPPqzvL4QtCY";
  public static String database = "bungeeban";
  public static Connection con;
  
  public static void connect()
  {
    if (!isConnected()) {
      try
      {
        con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static void disconnect()
  {
    if (isConnected()) {
      try
      {
        con.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static boolean isConnected()
  {
    return con != null;
  }
  
  public static Connection getConnection()
  {
    return con;
  }
}
