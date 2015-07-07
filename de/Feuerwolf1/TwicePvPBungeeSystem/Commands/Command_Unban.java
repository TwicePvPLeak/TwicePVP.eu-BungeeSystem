package de.Feuerwolf1.TwicePvPBungeeSystem.Commands;

import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Ban;
import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Strafen;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.command.PlayerCommand;

public class Command_Unban
  extends PlayerCommand
{
  public Command_Unban()
  {
    super("Unban", "TPS.Unban", new String[0]);
  }
  
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
  
  public void execute(CommandSender sender, String[] args)
  {
    if (args.length == 0) {
      sender.sendMessage("§cVerwendung: §b/Unban <Spieler>");
    } else if (args.length == 1)
    {
      if (Ban.isNameBanned(args[0].toLowerCase()))
      {
        Ban.removeBan(args[0].toLowerCase());
        Strafen.addStrafe(args[0].toLowerCase(), sender.getName(), this.sdf.format(this.date), "Unban", "l", "l");
        sender.sendMessage("§b[§6TPS§b] §aDu hast den Spieler §7" + args[0] + " §aentbannt!");
      }
      else
      {
        sender.sendMessage("§b[§6TPS§b] §cDer Spieler §7" + args[0] + " §cist nicht gebannt!");
      }
    }
    else {
      sender.sendMessage("§cVerwendung: §b/Unban <Spieler>");
    }
  }
}
