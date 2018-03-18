package de.nextround.nextrotate;

import de.nextround.nextrotate.command.simplerotateCommand;
import de.nextround.nextrotate.utils.fastRotate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Main extends JavaPlugin{

    private String prefix = "§8[§3nextRotate§8]";

    public HashMap<Player, Float> yawSave = new HashMap<Player, Float>();

    public fastRotate fastrotate;

    @Override
    public void onEnable() {
        registerCommands();
        this.fastrotate = new fastRotate(this);

        Bukkit.getConsoleSender().sendMessage("§8[§2nextRotate§8] §3The plugin is now §aEnabled");
        Bukkit.getConsoleSender().sendMessage("§8[§2nextRotate§8] §3Coded by: §enextRound");
        Bukkit.getConsoleSender().sendMessage("§8[§2nextRotate§8] §3Version: §e"+getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§8[§2nextRotate§8] §3Thank you for downloading my plugin!");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§8[§2nextRotate§8] §c(c) Copyright Matthias S. 2017/18");
    }

    private void registerCommands() {
        getCommand("nextrotate").setExecutor(new simplerotateCommand(this));
        getCommand("nr").setExecutor(new simplerotateCommand(this));
        getCommand("nrd").setExecutor(new simplerotateCommand(this));
    }

    public String getPrefix() {
        return prefix;
    }
}
