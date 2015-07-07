package de.Feuerwolf1.TwicePvPBungeeSystem.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ban
{
  public static boolean isNameBanned(String Spielername)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Ban WHERE Spieler = ?");
      ps.setString(1, Spielername);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return true;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }
  
  public static String getGrund(String Spielername)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Ban WHERE Spieler = ?");
      ps.setString(1, Spielername);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return rs.getString("Grund");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public static String getVon(String Spielername)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Ban WHERE Spieler = ?");
      ps.setString(1, Spielername);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return rs.getString("Von");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public static long getTime(String Spielername)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Ban WHERE Spieler = ?");
      ps.setString(1, Spielername);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return rs.getLong("Zeit");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return 0L;
  }
  
  public static void setBanned(String Spielername, String Grund, String Von, long Time)
  {
    if (!isNameBanned(Spielername)) {
      try
      {
        PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO Ban (Spieler, Grund, Von, Zeit) VALUES (?, ?, ?, ?)");
        ps.setString(1, Spielername);
        ps.setString(2, Grund);
        ps.setString(3, Von);
        ps.setLong(4, Time);
        ps.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    } else {
      try
      {
        PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE Ban SET Grund = ? WHERE Spieler = ?");
        PreparedStatement ps2 = MySQL.getConnection().prepareStatement("UPDATE Ban SET Von = ? WHERE Spieler = ?");
        PreparedStatement ps3 = MySQL.getConnection().prepareStatement("UPDATE Ban SET Zeit = ? WHERE Spieler = ?");
        
        ps.setString(1, Grund);
        ps.setString(2, Spielername);
        ps2.setString(1, Von);
        ps2.setString(2, Spielername);
        ps3.setLong(1, Time);
        ps3.setString(2, Spielername);
        
        ps.executeUpdate();
        ps2.executeUpdate();
        ps3.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static void removeBan(String Spielername)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE FROM Ban WHERE Spieler = ?");
      ps.setString(1, Spielername);
      ps.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
