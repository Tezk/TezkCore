package me.tezk.tezkcore;

import org.bukkit.plugin.java.JavaPlugin;

public class TezkCore extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        registerEvents();
        registerCommands();
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new ColourfulMOTD(this), this);
        getServer().getPluginManager().registerEvents(new LoginMessage(this), this);
        getServer().getPluginManager().registerEvents(new DisableBreakingBlocks(this), this);
        getServer().getPluginManager().registerEvents(new ColourChat(), this);
    }

    public void registerCommands() {
        getCommand("speed").setExecutor(new SpeedCommand(this));
        getCommand("tezkcore").setExecutor(new ReloadCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
    }
}
