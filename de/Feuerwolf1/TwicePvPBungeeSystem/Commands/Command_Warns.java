package de.Feuerwolf1.TwicePvPBungeeSystem.Commands;

import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Warns;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.command.PlayerCommand;

public class Command_Warns
  extends PlayerCommand
{
  public Command_Warns()
  {
    super("Warns", "TPS.Warns", new String[0]);
  }
  
  public void execute(CommandSender sender, String[] args)
  {
    if (args.length == 0) {
      sender.sendMessage("§b[§6TPS§b] §aDeine Warns: §b" + Warns.getWarns(sender.getName().toLowerCase()));
    } else if (args.length == 1) {
      sender.sendMessage("§b[§6TPS§b] §aWarns von " + args[0] + ": §b" + Warns.getWarns(args[0].toLowerCase()));
    } else {
      sender.sendMessage("§cVerwendung: §b/Warns [Spieler]");
    }
  }
}
