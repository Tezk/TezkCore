package me.tezk.tezkcore;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class LoginMessage implements Listener {

    private TezkCore plugin;

    public LoginMessage(TezkCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        List<String> loginMessage = plugin.getConfig().getStringList("login-message");
        for (String line : loginMessage) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', line).replace("%player%",
                    event.getPlayer().getName()) );
        }

    }
}
