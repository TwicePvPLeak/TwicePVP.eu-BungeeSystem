package de.Feuerwolf1.TwicePvPBungeeSystem.Commands;

import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Ban;
import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Strafen;
import de.Feuerwolf1.TwicePvPBungeeSystem.TimeManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.command.PlayerCommand;

public class Command_Tempban
  extends PlayerCommand
{
  public Command_Tempban()
  {
    super("Tempban", "TPS.Tempban", new String[0]);
  }
  
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
  
  public void execute(CommandSender sender, String[] args)
  {
    if (args.length == 0)
    {
      sender.sendMessage("§cVerwendung: §b/Tempban <Spieler> <Zeit> <Zeitform> [Grund]");
    }
    else if (args.length == 1)
    {
      sender.sendMessage("§cVerwendung: §b/Tempban <Spieler> <Zeit> <Zeitform> [Grund]");
    }
    else if (args.length == 2)
    {
      sender.sendMessage("§cVerwendung: §b/Tempban <Spieler> <Zeit> <Zeitform> [Grund]");
    }
    else if (args.length == 3)
    {
      int Zeit = 0;
      TimeManager TimeFormat = null;
      ProxiedPlayer p2 = ProxyServer.getInstance().getPlayer(args[0]);
      try
      {
        Zeit = Integer.valueOf(args[1]).intValue();
      }
      catch (NumberFormatException e)
      {
        sender.sendMessage("§b[§6TPS§b] §cDie Zeit muss eine gültige Zahl sein!");
      }
      try
      {
        TimeFormat = TimeManager.valueOf(args[2].toUpperCase());
      }
      catch (IllegalArgumentException e)
      {
        sender.sendMessage("§b[§6TPS§b] §cBitte gebe eine gültige Zeitform an!");
      }
      if (p2 != null)
      {
        long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
        String Form = Zeit + " " + TimeFormat.getOutput();
        Ban.setBanned(p2.getName().toLowerCase(), "--", sender.getName(), NeueZeit);
        Strafen.addStrafe(p2.getName().toLowerCase(), sender.getName(), this.sdf.format(this.date), "Tempban", Form, "--");
        p2.disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b-- \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
        if (sender.hasPermission("TPS.Admin"))
        {
          ProxyServer.getInstance().broadcast("§9Der Spieler §7" + p2.getName() + " §9wurde für " + Form + " §9gebannt!");
          ProxyServer.getInstance().broadcast("§9Grund: §b--");
        }
        else
        {
          ProxyServer.getInstance().broadcast("§9Der Spieler §7" + p2.getName() + " §9wurde von §e" + sender.getName() + " §9für " + Form + " §9gebannt!");
          ProxyServer.getInstance().broadcast("§9Grund: §b--");
        }
      }
      else
      {
        long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
        String Form = Zeit + " " + TimeFormat.getOutput();
        Ban.setBanned(args[0].toLowerCase(), "--", sender.getName(), NeueZeit);
        Strafen.addStrafe(args[0].toLowerCase(), sender.getName(), this.sdf.format(this.date), "Tempban", Form, "--");
        if (sender.hasPermission("TPS.Admin"))
        {
          ProxyServer.getInstance().broadcast("§9Der Spieler §7" + args[0] + " §9wurde für " + Form + " §9gebannt!");
          ProxyServer.getInstance().broadcast("§9Grund: §b--");
        }
        else
        {
          ProxyServer.getInstance().broadcast("§9Der Spieler §7" + args[0] + " §9wurde von §e" + sender.getName() + " §9für " + Form + " §9gebannt!");
          ProxyServer.getInstance().broadcast("§9Grund: §b--");
        }
      }
    }
    else
    {
      String Grund = "";
      for (int i = 3; i < args.length; i++) {
        Grund = Grund + args[i] + " ";
      }
      int Zeit = 0;
      TimeManager TimeFormat = null;
      ProxiedPlayer p2 = ProxyServer.getInstance().getPlayer(args[0]);
      try
      {
        Zeit = Integer.valueOf(args[1]).intValue();
      }
      catch (NumberFormatException e)
      {
        sender.sendMessage("§b[§6TPS§b] §cDie Zeit muss eine gültige Zahl sein!");
      }
      try
      {
        TimeFormat = TimeManager.valueOf(args[2].toUpperCase());
      }
      catch (IllegalArgumentException e)
      {
        sender.sendMessage("§b[§6TPS§b] §cBitte gebe eine gültige Zeitform an!");
      }
      if (p2 != null)
      {
        long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
        String Form = Zeit + " " + TimeFormat.getOutput();
        Ban.setBanned(p2.getName().toLowerCase(), Grund, sender.getName(), NeueZeit);
        Strafen.addStrafe(p2.getName().toLowerCase(), sender.getName(), this.sdf.format(this.date), "Tempban", Form, Grund);
        p2.disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b" + Grund + " \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
        if (sender.hasPermission("TPS.Admin"))
        {
          ProxyServer.getInstance().broadcast("§9Der Spieler §7" + p2.getName() + " §9wurde für " + Form + " §9gebannt!");
          ProxyServer.getInstance().broadcast("§9Grund: §b" + Grund);
        }
        else
        {
          ProxyServer.getInstance().broadcast("§9Der Spieler §7" + p2.getName() + " §9wurde von §e" + sender.getName() + " §9für " + Form + " §9gebannt!");
          ProxyServer.getInstance().broadcast("§9Grund: §b" + Grund);
        }
      }
      else
      {
        long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
        String Form = Zeit + " " + TimeFormat.getOutput();
        Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), NeueZeit);
        Strafen.addStrafe(args[0].toLowerCase(), sender.getName(), this.sdf.format(this.date), "Tempban", Form, Grund);
        if (sender.hasPermission("TPS.Admin"))
        {
          ProxyServer.getInstance().broadcast("§9Der Spieler §7" + args[0] + " §9wurde für " + Form + " §9gebannt!");
          ProxyServer.getInstance().broadcast("§9Grund: §b" + Grund);
        }
        else
        {
          ProxyServer.getInstance().broadcast("§9Der Spieler §7" + args[0] + " §9wurde von §e" + sender.getName() + " §9für " + Form + " §9gebannt!");
          ProxyServer.getInstance().broadcast("§9Grund: §b" + Grund);
        }
      }
    }
  }
}
