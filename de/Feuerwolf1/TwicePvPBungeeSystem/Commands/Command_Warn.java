package de.Feuerwolf1.TwicePvPBungeeSystem.Commands;

import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Ban;
import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Strafen;
import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Warns;
import de.Feuerwolf1.TwicePvPBungeeSystem.TimeManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.command.PlayerCommand;

public class Command_Warn
  extends PlayerCommand
{
  public Command_Warn()
  {
    super("Warn", "TPS.Warn", new String[0]);
  }
  
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
  
  public void execute(CommandSender sender, String[] args)
  {
    if (args.length == 0)
    {
      sender.sendMessage("§cVerwendung: §b/Warn <Spieler> <Anzahl> <Grund>");
    }
    else if (args.length == 1)
    {
      sender.sendMessage("§cVerwendung: §b/Warn <Spieler> <Anzahl> <Grund>");
    }
    else if (args.length == 2)
    {
      sender.sendMessage("§cVerwendung: §b/Warn <Spieler> <Anzahl> <Grund>");
    }
    else
    {
      String Grund = "";
      for (int i = 2; i < args.length; i++) {
        Grund = Grund + args[i] + " ";
      }
      int Anzahl = 0;
      try
      {
        Anzahl = Integer.valueOf(args[1]).intValue();
      }
      catch (NumberFormatException e)
      {
        sender.sendMessage("§b[§6TPS§b] §cDie Anzahl muss eine Zahl sein!");
      }
      if ((Anzahl > 0) && 
        (Anzahl < 13))
      {
        Warns.setWarns(args[0].toLowerCase(), Anzahl);
        Strafen.addStrafe(args[0].toLowerCase(), sender.getName(), this.sdf.format(this.date), "Warn", Anzahl + "x", Grund);
        if (sender.hasPermission("TPS.Admin"))
        {
          ProxyServer.getInstance().broadcast("§9Der Spieler §7" + args[0] + " §9wurde " + Anzahl + " mal gewarnt!");
          ProxyServer.getInstance().broadcast("§9Grund: §b" + Grund);
        }
        else
        {
          ProxyServer.getInstance().broadcast("§9Der Spieler §7" + args[0] + " §9wurde von §e" + sender.getName() + " §9" + Anzahl + " mal gewarnt!");
          ProxyServer.getInstance().broadcast("§9Grund: §b" + Grund);
        }
        if ((Warns.getWarns(args[0]) == 4) && (Strafen.getWarnLevel(args[0]) == 0))
        {
          int Zeit = 24;
          TimeManager TimeFormat = TimeManager.HOUR;
          long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
          String Form = Zeit + " " + TimeFormat.getOutput();
          Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), NeueZeit);
          Strafen.addStrafe(args[0].toLowerCase(), "CONSOLE", this.sdf.format(this.date), "Tempban", Form, "4 Warns ( " + Grund + ")");
          Strafen.addWarnLevel(args[0].toLowerCase());
          if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
            ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b4 Warns ( " + Grund + ") \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
          }
        }
        if ((Warns.getWarns(args[0]) == 5) && (Strafen.getWarnLevel(args[0]) == 0))
        {
          int Zeit = 24;
          TimeManager TimeFormat = TimeManager.HOUR;
          long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
          String Form = Zeit + " " + TimeFormat.getOutput();
          Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), NeueZeit);
          Strafen.addStrafe(args[0].toLowerCase(), "CONSOLE", this.sdf.format(this.date), "Tempban", Form, "5 Warns ( " + Grund + ")");
          Strafen.addWarnLevel(args[0].toLowerCase());
          if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
            ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b5 Warns ( " + Grund + ") \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
          }
        }
        if ((Warns.getWarns(args[0]) == 6) && (Strafen.getWarnLevel(args[0]) == 0))
        {
          int Zeit = 24;
          TimeManager TimeFormat = TimeManager.HOUR;
          long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
          String Form = Zeit + " " + TimeFormat.getOutput();
          Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), NeueZeit);
          Strafen.addStrafe(args[0].toLowerCase(), "CONSOLE", this.sdf.format(this.date), "Tempban", Form, "6 Warns ( " + Grund + ")");
          Strafen.addWarnLevel(args[0].toLowerCase());
          if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
            ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b6 Warns ( " + Grund + ") \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
          }
        }
        if ((Warns.getWarns(args[0]) == 7) && (Strafen.getWarnLevel(args[0]) == 0))
        {
          int Zeit = 24;
          TimeManager TimeFormat = TimeManager.HOUR;
          long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
          String Form = Zeit + " " + TimeFormat.getOutput();
          Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), NeueZeit);
          Strafen.addStrafe(args[0].toLowerCase(), "CONSOLE", this.sdf.format(this.date), "Tempban", Form, "7 Warns ( " + Grund + ")");
          Strafen.addWarnLevel(args[0].toLowerCase());
          if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
            ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b7 Warns ( " + Grund + ") \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
          }
        }
        if ((Warns.getWarns(args[0]) == 8) && (Strafen.getWarnLevel(args[0]) == 1))
        {
          int Zeit = 10;
          TimeManager TimeFormat = TimeManager.DAY;
          long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
          String Form = Zeit + " " + TimeFormat.getOutput();
          Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), NeueZeit);
          Strafen.addStrafe(args[0].toLowerCase(), "CONSOLE", this.sdf.format(this.date), "Tempban", Form, "8 Warns ( " + Grund + ")");
          Strafen.addWarnLevel(args[0].toLowerCase());
          if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
            ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b8 Warns ( " + Grund + ") \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
          }
        }
        if ((Warns.getWarns(args[0]) == 9) && (Strafen.getWarnLevel(args[0]) == 1))
        {
          int Zeit = 10;
          TimeManager TimeFormat = TimeManager.DAY;
          long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
          String Form = Zeit + " " + TimeFormat.getOutput();
          Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), NeueZeit);
          Strafen.addStrafe(args[0].toLowerCase(), "CONSOLE", this.sdf.format(this.date), "Tempban", Form, "9 Warns ( " + Grund + ")");
          Strafen.addWarnLevel(args[0].toLowerCase());
          if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
            ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b9 Warns ( " + Grund + ") \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
          }
        }
        if ((Warns.getWarns(args[0]) == 10) && (Strafen.getWarnLevel(args[0]) == 1))
        {
          int Zeit = 10;
          TimeManager TimeFormat = TimeManager.DAY;
          long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
          String Form = Zeit + " " + TimeFormat.getOutput();
          Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), NeueZeit);
          Strafen.addStrafe(args[0].toLowerCase(), "CONSOLE", this.sdf.format(this.date), "Tempban", Form, "10 Warns ( " + Grund + ")");
          Strafen.addWarnLevel(args[0].toLowerCase());
          if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
            ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b10 Warns ( " + Grund + ") \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
          }
        }
        if ((Warns.getWarns(args[0]) == 11) && (Strafen.getWarnLevel(args[0]) == 1))
        {
          int Zeit = 10;
          TimeManager TimeFormat = TimeManager.DAY;
          long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
          String Form = Zeit + " " + TimeFormat.getOutput();
          Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), NeueZeit);
          Strafen.addStrafe(args[0].toLowerCase(), "CONSOLE", this.sdf.format(this.date), "Tempban", Form, "11 Warns ( " + Grund + ")");
          Strafen.addWarnLevel(args[0].toLowerCase());
          if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
            ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b11 Warns ( " + Grund + ") \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
          }
        }
        if (Warns.getWarns(args[0]) > 11)
        {
          Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), 0L);
          Strafen.addStrafe(args[0].toLowerCase(), "CONSOLE", this.sdf.format(this.date), "Ban", "l", "12 Warns ( " + Grund + ")");
          Strafen.addWarnLevel(args[0].toLowerCase());
          if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
            ProxyServer.getInstance().getPlayer(args[0]).disconnect("§cDu wurdest §4permanent §cvom §eTwicePvP - Servernetzwerk §cgebannt! \n\n§cGrund: §b12 Warns ( " + Grund + ") \n§cGebannt von: §b" + sender.getName() + " \n\n§cDu kannst einen Entbannungsantrag \n§cauf §ewww.TwicePvP.org §cstellen!");
          }
        }
      }
    }
  }
}
