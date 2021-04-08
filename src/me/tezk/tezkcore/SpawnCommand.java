package me.tezk.tezkcore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private TezkCore plugin;

    public SpawnCommand(TezkCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You must be a player to use that command.");
                return true;
            }
            Player player = (Player) sender;
            if (!(args.length == 0)) {
                player.sendMessage(ChatColor.RED + "Invalid syntax. /spawn");
                return true;
            }
            player.teleport(plugin.getServer().getWorld("world").getSpawnLocation());
            player.sendMessage(ChatColor.GREEN + "Teleported to spawn!");
            return true;
        }
        return true;
    }
}
