package me.justeli.coins.cancel;

import me.justeli.coins.settings.Config;
import me.justeli.coins.settings.Settings;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Eli on 2/4/2017.
 */
public class CoinPlace implements Listener {

    @EventHandler
    public void coinPlace (PlayerInteractEvent e)
    {
        try
        {
            if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getItem().getItemMeta().hasDisplayName()) {
                String pickupName = e.getItem().getItemMeta().getDisplayName();
                String coinName = ChatColor.translateAlternateColorCodes('&', Settings.hS.get(Config.STRING.nameOfCoin));

                if (pickupName.contains(coinName))
                    e.setCancelled(true);

            }
        }
        catch (NullPointerException ignored) {}
    }

}