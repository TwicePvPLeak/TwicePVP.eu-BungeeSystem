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

public class Command_Hacks
  extends PlayerCommand
{
  public Command_Hacks()
  {
    super("Hacks", "TPS.Hacks", new String[0]);
  }
  
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
  
  public void execute(CommandSender sender, String[] args)
  {
    if (args.length == 0)
    {
      sender.sendMessage("§cVerwendung: §b/Hacks <Spieler>");
    }
    else if (args.length == 1)
    {
      int HackLevel = Strafen.getHackLevel(args[0].toLowerCase());
      if (!Strafen.isInHacks(args[0].toLowerCase()))
      {
        int Zeit = 7;
        TimeManager TimeFormat = TimeManager.DAY;
        long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
        String Form = Zeit + " " + TimeFormat.getOutput();
        if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
          ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §bAutomatisches Hacksystem: HackLevel 0 \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
        }
        Ban.setBanned(args[0].toLowerCase(), "Automatisches Hacksystem: Hacklevel 0", sender.getName(), NeueZeit);
        Strafen.addStrafe(args[0].toLowerCase(), sender.getName(), this.sdf.format(this.date), "Tempban", Form, "Automatisches Hacksystem: HackLevel 0");
        for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
          if (all.hasPermission("TPS.Team")) {
            all.sendMessage("§b[§6Team§b] §aDer Spieler §7" + args[0] + " §awurde für Hacks gebannt! Hacklevel: 0");
          }
        }
        Strafen.addHackLevel(args[0].toLowerCase());
      }
      if (HackLevel == 1)
      {
        int Zeit = 14;
        TimeManager TimeFormat = TimeManager.DAY;
        long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
        String Form = Zeit + " " + TimeFormat.getOutput();
        if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
          ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §bAutomatisches Hacksystem: HackLevel 1\n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
        }
        Ban.setBanned(args[0].toLowerCase(), "Automatisches Hacksystem: Hacklevel 1", sender.getName(), NeueZeit);
        Strafen.addStrafe(args[0].toLowerCase(), sender.getName(), this.sdf.format(this.date), "Tempban", Form, "Automatisches Hacksystem: HackLevel 1");
        for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
          if (all.hasPermission("TPS.Team")) {
            all.sendMessage("§b[§6Team§b] §aDer Spieler §7" + args[0] + " §awurde für Hacks gebannt! Hacklevel: 1");
          }
        }
        Strafen.addHackLevel(args[0].toLowerCase());
      }
      TimeManager TimeFormat;
      if (HackLevel == 2)
      {
        int Zeit = 30;
        TimeFormat = TimeManager.DAY;
        long NeueZeit = System.currentTimeMillis() / 1000L + Zeit * TimeFormat.getToSec();
        String Form = Zeit + " " + TimeFormat.getOutput();
        if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
          ProxyServer.getInstance().getPlayer(args[0]).disconnect("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §bAutomatisches Hacksystem: HackLevel 2 \n§9Gebannt von: §b" + sender.getName() + " \n§9Zeit: §b" + Form + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
        }
        Ban.setBanned(args[0].toLowerCase(), "Automatisches Hacksystem: Hacklevel 2", sender.getName(), NeueZeit);
        Strafen.addStrafe(args[0].toLowerCase(), sender.getName(), this.sdf.format(this.date), "Tempban", Form, "Automatisches Hacksystem: HackLevel 2");
        for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
          if (all.hasPermission("TPS.Team")) {
            all.sendMessage("§b[§6Team§b] §aDer Spieler §7" + args[0] + " §awurde für Hacks gebannt! Hacklevel: 2");
          }
        }
        Strafen.addHackLevel(args[0].toLowerCase());
      }
      if (HackLevel == 3)
      {
        if (ProxyServer.getInstance().getPlayer(args[0]) != null) {
          ProxyServer.getInstance().getPlayer(args[0]).disconnect("§cDu wurdest §4permanent §cvom §eTwicePvP - Servernetzwerk §cgebannt! \n\n§cGrund: §bAutomatisches Hacksystem: HackLevel 3 \n§cGebannt von: §b" + sender.getName() + " \n\n§cDu kannst einen Entbannungsantrag \n§cauf §ewww.TwicePvP.org §cstellen!");
        }
        Ban.setBanned(args[0].toLowerCase(), "Automatisches Hacksystem: Hacklevel 3", sender.getName(), 0L);
        Strafen.addStrafe(args[0].toLowerCase(), sender.getName(), this.sdf.format(this.date), "Ban", "l", "Automatisches Hacksystem: HackLevel 3");
        for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
          if (all.hasPermission("TPS.Team")) {
            all.sendMessage("§b[§6Team§b] §aDer Spieler §7" + args[0] + " §awurde für Hacks gebannt! Hacklevel: 3");
          }
        }
        Strafen.addHackLevel(args[0].toLowerCase());
      }
    }
    else
    {
      sender.sendMessage("§cVerwendung: §b/Hacks <Spieler>");
    }
  }
}
