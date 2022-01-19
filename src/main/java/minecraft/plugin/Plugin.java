package minecraft.plugin;

import minecraft.plugin.commands.administration.*;
import minecraft.plugin.commands.player.*;
import minecraft.plugin.listeners.*;

import minecraft.plugin.commands.util.ChatUtil;


import org.bukkit.plugin.java.JavaPlugin;


public final class Plugin extends JavaPlugin {
    public static Plugin instance;


    @Override
    public void onEnable() {
        instance = this;


        System.out.printf(ChatUtil.color("[ServerCore] Launching..."));


        //USEFULL
        this.getServer().getPluginManager().registerEvents(new blockedCommands(), this);
        this.getServer().getPluginManager().registerEvents(new enderPearlDamage(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerChatEvent(), this);
        //this.getServer().getPluginManager().registerEvents(new PlayerChatEvent(), this);
        //this.getServer().getPluginManager().registerEvents(new Chat(), this);


        //Players

        this.getCommand("regulamin").setExecutor(new Regulamin());
        this.getCommand("ec").setExecutor(new PlayerEnderchest());
        this.getCommand("vip").setExecutor(new VipCommand());

        //Staff
        this.getCommand("gamemode").setExecutor(new Gamemode());
        this.getCommand("broadcast").setExecutor(new Broadcast());
        this.getCommand("chat").setExecutor(new Chat());
        this.getCommand("test").setExecutor(new Test());
        this.getCommand("res").setExecutor(new Restart(this));
        this.getCommand("servercore").setExecutor(new ServerCore());
    }

    public static Plugin getInstance() {
        return instance;
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}









