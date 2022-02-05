package me.bloone;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Tools {
    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String line() {
        return "&7------------------------";
    }

    public static FileConfiguration getConfig() {
        return Bukkit.getPluginManager().getPlugin("bPChat").getConfig();
    }

    public static void reloadConfig() {
        Bukkit.getPluginManager().getPlugin("bPChat").reloadConfig();
    }

    public static void saveConfig() {
        Bukkit.getPluginManager().getPlugin("bPChat").saveConfig();
    }
}
