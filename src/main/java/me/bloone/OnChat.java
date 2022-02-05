package me.bloone;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnChat implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (Tools.getConfig().getBoolean("Data.Mute." + p.getUniqueId() + ".Muted")) {
            e.setCancelled(true);
            p.sendMessage(Tools.color("&cYou can't send messages, because you're muted.\n&7Reason: &r" + Tools.getConfig().getString("Data.Mute." + p.getUniqueId() + ".Reason")));
        }
    }
}
