// Code by Xemu (https://www.github.com/codebyxemu)
package me.xemu.xemcaptcha;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CaptchaListener implements Listener
{

    @EventHandler public void onPlayerJoin(final PlayerJoinEvent event)
    {

        final Player player = event.getPlayer();
        final String bypassPermission = "xemcaptcha.bypass";
        boolean bypassEnabled = true;

        if(bypassEnabled && player.hasPermission(bypassPermission)) return;

    };

};