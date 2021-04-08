package me.tezk.tezkcore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

    private TezkCore plugin;

    public SpeedCommand(TezkCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("speed")) {

            if (args.length == 1) {

                if (!(sender instanceof Player)) {

                    sender.sendMessage(ChatColor.RED + "That command is only available in-game.");
                    return true;

                } else {

                    Player player = (Player) sender;

                    try {

                        if (Integer.valueOf(args[0]) < 1 || Integer.valueOf(args[0]) > 5) {
                            player.sendMessage(ChatColor.RED + "Wrong syntax. /speed <1-5>");
                            return true;
                        }
                        float speed = (float) Integer.valueOf(args[0])/10;

                        player.setFlySpeed(speed);
                        player.sendMessage("Speed changed to " + args[0]);
                        return true;


                    } catch (Exception e) {

                        player.sendMessage(ChatColor.RED + "Wrong syntax. /speed <1-5>");
                        return true;

                    }

                }

            } else {
                sender.sendMessage(ChatColor.RED + "Wrong syntax. /speed <1-5>");
                return true;

            }

        }

        return true;
    }


}
