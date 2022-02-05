package me.bloone;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (Tools.getConfig().getBoolean("Settings.Join.broadcastMessage") == true) {
            e.setJoinMessage(Tools.color(Tools.getConfig().getString("Messages.Join.message").replace("%player%", e.getPlayer().getDisplayName())));
        }
        if (Tools.getConfig().getBoolean("Settings.Join.sendActionBarMessageToPlayer") == true) {
            e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(Tools.color(Tools.getConfig().getString("Messages.Join.actionBarMessage").replace("%player%", e.getPlayer().getDisplayName()))));
        }
    }
}
