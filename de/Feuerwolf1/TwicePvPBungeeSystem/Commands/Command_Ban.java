package de.Feuerwolf1.TwicePvPBungeeSystem.Commands;

import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Ban;
import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Strafen;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.command.PlayerCommand;

public class Command_Ban
  extends PlayerCommand
{
  public Command_Ban()
  {
    super("Ban", "TPS.Ban", new String[0]);
  }
  
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
  
  public void execute(CommandSender sender, String[] args)
  {
    if (args.length == 0)
    {
      sender.sendMessage("§cVerwendung: §b/Ban <Spieler> [Grund]");
    }
    else if (args.length == 1)
    {
      ProxiedPlayer p2 = ProxyServer.getInstance().getPlayer(args[0]);
      if (p2 != null)
      {
        Ban.setBanned(p2.getName().toLowerCase(), "--", sender.getName(), 0L);
        Strafen.addStrafe(p2.getName().toLowerCase(), sender.getName(), this.sdf.format(this.date), "Ban", "l", "--");
        p2.disconnect("§cDu wurdest §4permanent §cvom §eTwicePvP - Servernetzwerk §cgebannt! \n\n§cGrund: §b-- \n§cGebannt von: §b" + sender.getName() + " \n\n§cDu kannst einen Entbannungsantrag \n§cauf §ewww.TwicePvP.org §cstellen!");
        if (sender.hasPermission("TPS.Admin"))
        {
          ProxyServer.getInstance().broadcast("§cDer Spieler §7" + p2.getName() + " §cwurde permanent gebannt!");
          ProxyServer.getInstance().broadcast("§cGrund: §b--");
        }
        else
        {
          ProxyServer.getInstance().broadcast("§cDer Spieler §7" + p2.getName() + " §cwurde von §e" + sender.getName() + " §cpermanent gebannt!");
          ProxyServer.getInstance().broadcast("§cGrund: §b--");
        }
      }
      else
      {
        Ban.setBanned(args[0].toLowerCase(), "--", sender.getName(), 0L);
        Strafen.addStrafe(args[0].toLowerCase(), sender.getName(), this.sdf.format(this.date), "Ban", "l", "--");
        if (sender.hasPermission("TPS.Admin"))
        {
          ProxyServer.getInstance().broadcast("§cDer Spieler §7" + args[0] + " §cwurde permanent gebannt!");
          ProxyServer.getInstance().broadcast("§cGrund: §b--");
        }
        else
        {
          ProxyServer.getInstance().broadcast("§cDer Spieler §7" + args[0] + " §cwurde von §e" + sender.getName() + " §cpermanent gebannt!");
          ProxyServer.getInstance().broadcast("§cGrund: §b--");
        }
      }
    }
    else
    {
      String Grund = "";
      for (int i = 1; i < args.length; i++) {
        Grund = Grund + args[i] + " ";
      }
      ProxiedPlayer p2 = ProxyServer.getInstance().getPlayer(args[0]);
      if (p2 != null)
      {
        Ban.setBanned(p2.getName().toLowerCase(), Grund, sender.getName(), 0L);
        Strafen.addStrafe(p2.getName().toLowerCase(), sender.getName(), this.sdf.format(this.date), "Ban", "l", Grund);
        p2.disconnect("§cDu wurdest §4permanent §cvom §eTwicePvP - Servernetzwerk §cgebannt! \n\n§cGrund: §b" + Grund + " \n§cGebannt von: §b" + sender.getName() + " \n\n§cDu kannst einen Entbannungsantrag \n§cauf §ewww.TwicePvP.org §cstellen!");
        if (sender.hasPermission("TPS.Admin"))
        {
          ProxyServer.getInstance().broadcast("§cDer Spieler §7" + p2.getName() + " §cwurde permanent gebannt!");
          ProxyServer.getInstance().broadcast("§cGrund: §b" + Grund);
        }
        else
        {
          ProxyServer.getInstance().broadcast("§cDer Spieler §7" + p2.getName() + " §cwurde von §e" + sender.getName() + " §cpermanent gebannt!");
          ProxyServer.getInstance().broadcast("§cGrund: §b" + Grund);
        }
      }
      else
      {
        Ban.setBanned(args[0].toLowerCase(), Grund, sender.getName(), 0L);
        Strafen.addStrafe(args[0].toLowerCase(), sender.getName(), this.sdf.format(this.date), "Ban", "l", Grund);
        if (sender.hasPermission("TPS.Admin"))
        {
          ProxyServer.getInstance().broadcast("§cDer Spieler §7" + args[0] + " §cwurde permanent gebannt!");
          ProxyServer.getInstance().broadcast("§cGrund: §b" + Grund);
        }
        else
        {
          ProxyServer.getInstance().broadcast("§cDer Spieler §7" + args[0] + " §cwurde von §e" + sender.getName() + " §cpermanent gebannt!");
          ProxyServer.getInstance().broadcast("§cGrund: §b" + Grund);
        }
      }
    }
  }
}
