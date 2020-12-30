// Code by Xemu (https://www.github.com/codebyxemu)
package me.xemu.xemcaptcha;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class XemCaptcha extends JavaPlugin {


    private static XemCaptcha instance;
    public static FileConfiguration cfg = instance.getConfig();

    @Override public void onEnable()
    {
        instance = this;
    };

    @Override public void onDisable()
    {
        instance = null;
    };

}
