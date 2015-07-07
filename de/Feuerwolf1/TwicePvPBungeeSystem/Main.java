package de.Feuerwolf1.TwicePvPBungeeSystem;

import de.Feuerwolf1.TwicePvPBungeeSystem.Commands.Command_Ban;
import de.Feuerwolf1.TwicePvPBungeeSystem.Commands.Command_Hacks;
import de.Feuerwolf1.TwicePvPBungeeSystem.Commands.Command_Strafen;
import de.Feuerwolf1.TwicePvPBungeeSystem.Commands.Command_Tempban;
import de.Feuerwolf1.TwicePvPBungeeSystem.Commands.Command_Unban;
import de.Feuerwolf1.TwicePvPBungeeSystem.Commands.Command_Warn;
import de.Feuerwolf1.TwicePvPBungeeSystem.Commands.Command_Warns;
import de.Feuerwolf1.TwicePvPBungeeSystem.Events.Event_ChatEvent;
import de.Feuerwolf1.TwicePvPBungeeSystem.Events.Event_LoginEvent;
import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class Main
  extends Plugin
{
  public void onEnable()
  {
    MySQL.connect();
    loadMySQL();
    
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command_Ban());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command_Unban());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command_Tempban());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command_Strafen());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command_Hacks());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command_Warn());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command_Warns());
    
    ProxyServer.getInstance().getPluginManager().registerListener(this, new Event_LoginEvent());
    ProxyServer.getInstance().getPluginManager().registerListener(this, new Event_ChatEvent());
  }
  
  public static void loadMySQL()
  {
    try
    {
      PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Ban (Spieler VARCHAR(255), Grund VARCHAR(255), Von VARCHAR(255), Zeit INT)");
      PreparedStatement ps2 = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Strafen (Spieler VARCHAR(255), Datum VARCHAR(255), Strafe VARCHAR(255), Anzahl VARCHAR(255), Von VARCHAR(255), Grund VARCHAR(255))");
      PreparedStatement ps3 = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Hacks (Spieler VARCHAR(255), HackLevel INT, WarnLevel INT)");
      PreparedStatement ps4 = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Warns (Spieler VARCHAR(255), Warns INT)");
      ps.executeUpdate();
      ps2.executeUpdate();
      ps3.executeUpdate();
      ps4.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
