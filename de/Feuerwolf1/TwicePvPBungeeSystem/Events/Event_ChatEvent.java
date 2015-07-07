package de.Feuerwolf1.TwicePvPBungeeSystem.Events;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Event_ChatEvent
  implements Listener
{
  @EventHandler
  public void on(ChatEvent e)
  {
    ProxiedPlayer p = (ProxiedPlayer)e.getSender();
    if (((p.getServer().getInfo().getName().equalsIgnoreCase("lobby01")) || (p.getServer().getInfo().getName().equalsIgnoreCase("lobby02")) || (p.getServer().getInfo().getName().equalsIgnoreCase("lobby03")) || (p.getServer().getInfo().getName().equalsIgnoreCase("lobby04"))) && (
      (e.getMessage().toLowerCase().contains("/gban")) || 
      (e.getMessage().toLowerCase().contains("/ghtempban")) || 
      (e.getMessage().toLowerCase().contains("/greload")) || 
      (e.getMessage().toLowerCase().contains("/reload-motds")) || 
      (e.getMessage().toLowerCase().contains("/gtempban")) || 
      (e.getMessage().toLowerCase().contains("/gunban")) || 
      (e.getMessage().toLowerCase().contains("/server")) || 
      (e.getMessage().toLowerCase().contains("/ip")) || 
      (e.getMessage().toLowerCase().contains("/alert")) || 
      (e.getMessage().toLowerCase().contains("/end")) || 
      (e.getMessage().toLowerCase().contains("/send")) || 
      (e.getMessage().toLowerCase().contains("/announce_list")) || 
      (e.getMessage().toLowerCase().contains("/announce_remove")) || 
      (e.getMessage().toLowerCase().contains("/announce_add")) || 
      (e.getMessage().toLowerCase().contains("/party")) || 
      (e.getMessage().toLowerCase().contains("/bungee")) || 
      (e.getMessage().toLowerCase().contains("/wartung")) || 
      (e.getMessage().toLowerCase().contains("/mem")) || 
      (e.getMessage().toLowerCase().contains("/warn")) || 
      (e.getMessage().toLowerCase().contains("/ban")) || 
      (e.getMessage().toLowerCase().contains("/tempban")) || 
      (e.getMessage().toLowerCase().contains("/hacks")) || 
      (e.getMessage().toLowerCase().contains("/unban")))) {
      e.setCancelled(true);
    }
  }
}
