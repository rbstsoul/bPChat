package me.bloone;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnQuit implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        if (Tools.getConfig().getBoolean("Settings.Quit.broadcastMessage") == true) {
            e.setQuitMessage(Tools.color(Tools.getConfig().getString("Messages.Quit.message").replace("%player%", e.getPlayer().getDisplayName())));
        }
    }
}
