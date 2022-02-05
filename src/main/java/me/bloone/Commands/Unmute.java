package me.bloone.Commands;

import me.bloone.Tools;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Unmute implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Tools.color(Tools.getConfig().getString("Settings.prefix") + " &7You need to specify a player."));
        } else if (args.length == 1) {
            if (Tools.getConfig().contains("Data.Mute." + Bukkit.getPlayer(args[0]).getUniqueId())) {
                Tools.getConfig().set("Data.Mute." + Bukkit.getPlayer(args[0]).getUniqueId(), null);
                Tools.saveConfig();
            }
            sender.sendMessage(Tools.color(Tools.getConfig().getString("Settings.prefix") + " &aUnmuted successful!"));
        }
        return true;
    }
}
