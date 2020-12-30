// Code by Xemu (https://www.github.com/codebyxemu)
package me.xemu.xemcaptcha.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.UUID;

public class CaptchaGUIListener implements Listener
{

    @EventHandler public void onClick(final InventoryClickEvent event){
        if (!(event.getWhoClicked() instanceof Player))
        {
            return;
        };

        final Player player = (Player) event.getWhoClicked();
        final UUID playerUUID = player.getUniqueId();

        final UUID inventoryUUID = CaptchaGUI.openInventories.get(playerUUID);
        if (inventoryUUID != null)
        {
            event.setCancelled(true);
            CaptchaGUI gui = CaptchaGUI.getInventoriesByUUID().get(inventoryUUID);
            CaptchaGUI.CaptchaGUIAction action = gui.getActions().get(event.getSlot());

            if (action != null)
            {
                action.click(player);
            };
        };
    };

    @EventHandler public void onClose(final InventoryCloseEvent event)
    {
        final Player player = (Player) event.getPlayer();
        final UUID playerUUID = player.getUniqueId();

        CaptchaGUI.openInventories.remove(playerUUID);
    }
};