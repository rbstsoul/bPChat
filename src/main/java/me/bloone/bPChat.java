package me.bloone;

import me.bloone.Commands.Main;
import me.bloone.Commands.Mute;
import me.bloone.Commands.Unmute;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class bPChat extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(Tools.color("\n" + Tools.line() + "\n\n&6bPChat &ais working!\n&fCreator: &ebloone#2786\n\n" + Tools.line()));
        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        getServer().getPluginManager().registerEvents(new OnQuit(), this);
        getServer().getPluginManager().registerEvents(new OnChat(), this);
        getCommand("bpchat").setExecutor(new Main());
        getCommand("mute").setExecutor(new Mute());
        getCommand("unmute").setExecutor(new Unmute());
        loadConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info(Tools.color("\n" + Tools.line() + "\n\n&6bPChat &cis closed!\n&fCreator: &ebloone#2786\n\n" + Tools.line()));
    }

    public void loadConfig() {
        saveDefaultConfig();
        File configFile = new File(getDataFolder(), "config.yml");
        try {
            ConfigUpdater.update(this, "config.yml", configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reloadConfig();
    }
}
