package de.Feuerwolf1.TwicePvPBungeeSystem.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Warns
{
  public static boolean isPlayerExists(String Spielername)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Warns WHERE Spieler = ?");
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
  
  public static void setWarns(String Spielername, int Anzahl)
  {
    if (!isPlayerExists(Spielername)) {
      try
      {
        PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO Warns (Spieler, Warns) VALUES (?, ?)");
        ps.setString(1, Spielername);
        ps.setInt(2, Anzahl);
        ps.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    } else {
      try
      {
        int Warns = getWarns(Spielername) + Anzahl;
        PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE Warns SET Warns = ? WHERE Spieler = ?");
        ps.setInt(1, Warns);
        ps.setString(2, Spielername);
        ps.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static int getWarns(String Spielername)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Warns WHERE Spieler = ?");
      ps.setString(1, Spielername);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return rs.getInt("Warns");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return 0;
  }
}
