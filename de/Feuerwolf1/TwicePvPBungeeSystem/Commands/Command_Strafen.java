package de.Feuerwolf1.TwicePvPBungeeSystem.Commands;

import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Strafen;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.command.PlayerCommand;

public class Command_Strafen
  extends PlayerCommand
{
  public Command_Strafen()
  {
    super("Strafen", "TPS.Strafen", new String[0]);
  }
  
  public void execute(CommandSender sender, String[] args)
  {
    if (args.length == 0) {
      Strafen.sendStrafen((ProxiedPlayer)sender, sender.getName().toLowerCase());
    } else if (args.length == 1) {
      Strafen.sendStrafen((ProxiedPlayer)sender, args[0].toLowerCase());
    } else {
      sender.sendMessage("§cVerwendung: §b/Strafen [Spieler]");
    }
  }
}
