package de.Feuerwolf1.TwicePvPBungeeSystem.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Strafen
{
  public static boolean isUserExists(String Spieler)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Strafe FROM Strafen WHERE Spieler = ?");
      ps.setString(1, Spieler);
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
  
  public static void addStrafe(String Spieler, String Von, String Datum, String Art, String Anzahl, String Grund)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO Strafen (Spieler, Von, Datum, Strafe, Anzahl, Grund) VALUES (?, ?, ?, ?, ?, ?)");
      ps.setString(1, Spieler);
      ps.setString(2, Von);
      ps.setString(3, Datum);
      ps.setString(4, Art);
      ps.setString(5, Anzahl);
      ps.setString(6, Grund);
      ps.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  public static boolean isInHacks(String Spielername)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Hacks WHERE Spieler = ?");
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
  
  public static void addHackLevel(String Spielername)
  {
    if (isInHacks(Spielername)) {
      try
      {
        PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE Hacks SET HackLevel = ? WHERE Spieler = ?");
        ps.setInt(1, getHackLevel(Spielername) + 1);
        ps.setString(2, Spielername);
        ps.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    } else {
      try
      {
        PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO Hacks (Spieler, HackLevel, WarnLevel) VALUES (?, ?, ?)");
        ps.setString(1, Spielername);
        ps.setInt(2, 1);
        ps.setInt(3, 0);
        ps.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static void addWarnLevel(String Spielername)
  {
    if (isInHacks(Spielername)) {
      try
      {
        PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE Hacks SET WarnLevel = ? WHERE Spieler = ?");
        ps.setInt(1, getWarnLevel(Spielername) + 1);
        ps.setString(2, Spielername);
        ps.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    } else {
      try
      {
        PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO Hacks (Spieler, HackLevel, WarnLevel) VALUES (?, ?, ?)");
        ps.setString(1, Spielername);
        ps.setInt(2, 0);
        ps.setInt(3, 1);
        ps.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static int getWarnLevel(String Spielername)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Hacks WHERE Spieler = ?");
      ps.setString(1, Spielername);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return rs.getInt("WarnLevel");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return 0;
  }
  
  public static int getHackLevel(String Spielername)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Hacks WHERE Spieler = ?");
      ps.setString(1, Spielername);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return rs.getInt("HackLevel");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return 0;
  }
  
  public static void sendStrafen(ProxiedPlayer p, String Spieler)
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Strafen WHERE Spieler = ? ORDER BY Datum");
      ps.setString(1, Spieler);
      ResultSet rs = ps.executeQuery();
      p.sendMessage("§a[]========= §6Strafen von " + Spieler + " §a=========[]");
      while (rs.next())
      {
        String Datum = rs.getString("Datum");
        String[] DatumArray = Datum.split(":");
        String DatumText = DatumArray[0] + ":" + DatumArray[1];
        if (!rs.getString("Grund").equalsIgnoreCase("l"))
        {
          if (!rs.getString("Anzahl").equalsIgnoreCase("l")) {
            p.sendMessage("§f" + DatumText + " §c" + rs.getString("Strafe") + ": §b" + rs.getString("Anzahl") + " §bv. " + rs.getString("Von") + " Grund: " + rs.getString("Grund"));
          } else {
            p.sendMessage("§f" + DatumText + " §c" + rs.getString("Strafe") + ": §bv. " + rs.getString("Von") + " Grund: " + rs.getString("Grund"));
          }
        }
        else if (!rs.getString("Anzahl").equalsIgnoreCase("l")) {
          p.sendMessage("§f" + DatumText + " §c" + rs.getString("Strafe") + ": §b" + rs.getString("Anzahl") + " §bv. " + rs.getString("Von"));
        } else {
          p.sendMessage("§f" + DatumText + " §c" + rs.getString("Strafe") + ": §bv. " + rs.getString("Von"));
        }
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
