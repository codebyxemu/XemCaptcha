// Code by Xemu (https://www.github.com/codebyxemu)
package me.xemu.xemcaptcha.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class CaptchaGUI
{

    private final UUID uuid;
    private final Inventory inv;
    private final Map<Integer, CaptchaGUIAction> actions;
    public static Map<UUID, CaptchaGUI> inventoriesByUUID = new HashMap<>();
    public static Map<UUID, UUID> openInventories = new HashMap<>();


    public CaptchaGUI(final int invSize, final String invName)
    {
        uuid = UUID.randomUUID();
        inv = Bukkit.getServer().createInventory(null, invSize, invName);
        actions = new HashMap<Integer, CaptchaGUIAction>();
    };

    public Inventory getInv()
    {
         return inv;
    };

    public interface CaptchaGUIAction
    {
        void click(Player player);
    };

    public void setItem(final int slot, final ItemStack stack, final CaptchaGUIAction action)
    {
        inv.setItem(slot, stack);
        if (action != null)
        {
            actions.put(slot, action);
        };
    };

    public void setItem(final int slot, final ItemStack stack)
    {
        setItem(slot, stack, null);
    };

    public void open(final Player p)
    {
        p.openInventory(inv);
        openInventories.put(p.getUniqueId(), getUUID());
    };

    public UUID getUUID()
    {
        return uuid;
    };

    public static Map<UUID, CaptchaGUI> getInventoriesByUUID()
    {
        return inventoriesByUUID;
    };

    public static Map<UUID, UUID> getOpenInventories()
    {
        return openInventories;
    };

    public Map<Integer, CaptchaGUIAction> getActions()
    {
        return actions;
    };


};
