package me.tezk.tezkcore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private TezkCore plugin;

    public ReloadCommand(TezkCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tezkcore")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    plugin.saveDefaultConfig();
                    sender.sendMessage(ChatColor.GREEN + "Configuration reloaded successfully!");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "Invalid syntax. /tezkcore reload");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Invalid syntax. /tezkcore reload");
                return true;
            }
        }
        return true;
    }
}
