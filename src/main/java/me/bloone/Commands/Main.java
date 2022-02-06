package me.bloone.Commands;

import me.bloone.Tools;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Main implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("bpchat")) {
            if (args.length == 0) {
                if (sender.hasPermission("bpchat.command.main")) {
                    sender.sendMessage(Tools.color(Tools.line() + "\n\n&6bPChat &7- &fMain Command\n\n&e/bpchat &7- &fShows this page.\n&e/bpchat reload &7- &fReloads the plugin.\n\n" + Tools.line()));
                } else {
                    sender.sendMessage(Tools.color(Tools.getConfig().getString("Messages.noPermission")));
                }
            } else {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (sender.hasPermission("bpchat.command.reload")) {
                        sender.sendMessage(Tools.color(Tools.getConfig().getString("Messages.Reload.message1")));
                        Tools.reloadConfig();
                        sender.sendMessage(Tools.color(Tools.getConfig().getString("Messages.Reload.message2")));
                    } else {
                        sender.sendMessage(Tools.color(Tools.getConfig().getString("Messages.noPermission")));
                    }
                }
            }
        }
        return true;
    }

}
