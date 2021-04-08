package me.tezk.tezkcore;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class DisableBreakingBlocks implements Listener {

    private TezkCore plugin;

    public DisableBreakingBlocks(TezkCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        boolean disableBreaking = plugin.getConfig().getBoolean("disable-breaking.enabled");
        boolean everyone = plugin.getConfig().getBoolean("disable-breaking.everyone");
        if (disableBreaking && everyone) {
            event.setCancelled(true);
        } else if (disableBreaking && !(everyone)) {
            if (event.getPlayer().hasPermission("tezkcore.disablebreaking")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerBuild(BlockPlaceEvent event) {
        boolean disableBreaking = plugin.getConfig().getBoolean("disable-breaking.enabled");
        boolean everyone = plugin.getConfig().getBoolean("disable-breaking.everyone");
        if (disableBreaking && everyone) {
            event.setCancelled(true);
        } else if (disableBreaking && !(everyone)) {
            if (event.getPlayer().hasPermission("tezkcore.disablebreaking")) {
                event.setCancelled(true);
            }
        }
    }
}
