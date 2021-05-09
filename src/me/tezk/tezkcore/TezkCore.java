package me.tezk.tezkcore;

import org.bukkit.plugin.java.JavaPlugin;

public class TezkCore extends JavaPlugin {

    private String message;
    private boolean colourful;
    private List<String> colourListConfig;
    private List<String> loginMessage;
    private boolean disableBreaking;
    private boolean disableBreakingEveryone;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        updateConfig();
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

    public void updateConfig() {
        this.message = plugin.getConfig().getString("motd.message");
        this.colourful = plugin.getConfig().getBoolean("motd.colourful");
        this.colourListConfig = plugin.getConfig().getStringList("motd.colours");
        this.loginMessage = plugin.getConfig().getStringList("login-message");
        this.disableBreaking = plugin.getConfig().getBoolean("disable-breaking.enabled");
        this.disableBreakingEveryone = plugin.getConfig().getBoolean("disable-breaking.everyone");
    }

    public String getMotdMessage() {
        return this.message;
    }

    public boolean colourEnabled() {
        return this.colourful;
    }

    public List<String> getColourListConfig() {
        return this.colourListConfig;
    }

    public List<String> getLoginMessage() {
        return this.loginMessage;
    }

    public boolean isDisableBreaking() {
        return this.disableBreaking;
    }

    public boolean isDisableBreakingEveryone() {
        return this.disableBreakingEveryone;
    }
}
