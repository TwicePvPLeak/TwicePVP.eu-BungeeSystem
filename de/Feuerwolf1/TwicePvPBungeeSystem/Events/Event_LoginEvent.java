package de.Feuerwolf1.TwicePvPBungeeSystem.Events;

import de.Feuerwolf1.TwicePvPBungeeSystem.MySQL.Ban;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Event_LoginEvent
  implements Listener
{
  @EventHandler
  public void on(LoginEvent e)
  {
    String Spielername = e.getConnection().getName().toLowerCase();
    if (Ban.isNameBanned(Spielername)) {
      if (Ban.getTime(Spielername) == 0L)
      {
        e.setCancelled(true);
        e.setCancelReason("§cDu wurdest §4permanent §cvom §eTwicePvP - Servernetzwerk §cgebannt! \n\n§cGrund: §b" + Ban.getGrund(Spielername) + " \n§cGebannt von: §b" + Ban.getVon(Spielername) + " \n\n§cDu kannst einen Entbannungsantrag \n§cauf §ewww.TwicePvP.org §cstellen!");
      }
      else if (System.currentTimeMillis() / 1000L < Ban.getTime(Spielername))
      {
        Date date = new Date(Ban.getTime(Spielername) * 1000L);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        e.setCancelled(true);
        e.setCancelReason("§9Du wurdest §ezeitlich §9vom §eTwicePvP - Servernetzwerk §9gebannt! \n\n§9Grund: §b" + Ban.getGrund(Spielername) + " \n§9Gebannt von: §b" + Ban.getVon(Spielername) + " \n§9Zeit bis zum Unbann: §b" + format.format(date) + " \n\n§9Du kannst einen Entbannungsantrag \n§9auf §ewww.TwicePvP.org §9stellen!");
      }
      else
      {
        e.setCancelled(false);
        Ban.removeBan(Spielername);
      }
    }
  }
}
