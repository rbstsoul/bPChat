package me.bloone.Commands;

import me.bloone.Tools;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Mute implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("bpchat.command.mute")) {
            if (args.length == 0) {
                sender.sendMessage(Tools.color(Tools.getConfig().getString("Settings.prefix") + " &7You need to specify a player."));
            } else if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) == null) {
                    sender.sendMessage(Tools.color(Tools.getConfig().getString("Settings.prefix") + " &7The player that you specified isn't online."));
                } else {
                    Tools.getConfig().set("Data.Mute." + Bukkit.getPlayer(args[0]).getUniqueId() + ".Muted", true);
                    Tools.getConfig().set("Data.Mute." + Bukkit.getPlayer(args[0]).getUniqueId() + ".Reason", Tools.getConfig().getString("Settings.Mute.defaultReason"));
                    Tools.saveConfig();
                    sender.sendMessage(Tools.color(Tools.getConfig().getString("Settings.prefix") + " &aMuted successful!\n&7Reason: &r" + Tools.getConfig().getString("Settings.Mute.defaultReason")));
                }
            } else if (args.length >= 2) {
                if (Bukkit.getPlayer(args[0]) == null) {
                    sender.sendMessage(Tools.color(Tools.getConfig().getString("Settings.prefix") + " &7The player that you specified isn't online."));
                } else {
                    StringBuilder sb = new StringBuilder();
                    Tools.getConfig().set("Data.Mute." + Bukkit.getPlayer(args[0]).getUniqueId() + ".Muted", true);
                    for (int i = 1; i < args.length; i++) {
                        sb.append(args[i]).append(" ");
                    }
                    String reason = sb.toString().trim();
                    Tools.getConfig().set("Data.Mute." + Bukkit.getPlayer(args[0]).getUniqueId() + ".Reason", reason);
                    Tools.saveConfig();
                    sender.sendMessage(Tools.color(Tools.getConfig().getString("Settings.prefix") + " &aMuted successful!\n&7Reason: &r" + reason));
                }
            }
        } else {
            sender.sendMessage(Tools.color(Tools.getConfig().getString("Messages.noPermission")));
        }
        return true;
    }
}
